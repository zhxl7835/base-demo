package com.basedemo.security.basedemo03security.service.impl;

import com.basedemo.security.basedemo03security.dao.SysUserMapper;
import com.basedemo.security.basedemo03security.entity.SysMenu;
import com.basedemo.security.basedemo03security.entity.SysRole;
import com.basedemo.security.basedemo03security.entity.SysUser;
import com.basedemo.security.basedemo03security.service.SysMenuService;
import com.basedemo.security.basedemo03security.service.SysRoleService;
import com.basedemo.security.basedemo03security.service.SysUserService;
import com.basedemo.security.basedemo03security.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Service
public class SysUserServiceImpl  implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public SysUser getByUsername(String username) {
        // 获取用户信息
        SysUser sysUser = sysUserMapper.getByUsername(username);
        if (!redisUtil.hasKey("sysUser:" + username)) {
            redisUtil.set("sysUser:" + username, sysUser, 60 * 60);
        }
        return sysUser;
    }

    @Override
    public String getUserAuthorityInfo(Long userId) {
        // 获取用户信息
        SysUser sysUser = sysUserMapper.selectById(userId);

        //获取角色和权限
        String authority = "";//权限
        String code = "";//存入Redis角色
        String roleIds = "";//数据库查询角色
        if (redisUtil.hasKey("GrantedAuthority:" + sysUser.getUsername())) {
            code = (String) redisUtil.get("Roles:" + sysUser.getUsername());
            authority = (String) redisUtil.get("GrantedAuthority:" + sysUser.getUsername());

        } else {
            // 获取角色编码
            List<SysRole> roles = sysRoleService.getRoles(sysUser.getId());
            if (roles.size() > 0) {
                code = roles.stream().map(r -> "ROLE_" + r.getCode()).collect(Collectors.joining(","));
                roleIds = roles.stream().map(r -> r.getId().toString()).collect(Collectors.joining(","));
            }

            // 获取权限编码
            List<SysMenu> menus = sysMenuService.getMenus(roleIds);
            if (menus.size() > 0) {
                authority = menus.stream().map(m -> m.getPerms()).collect(Collectors.joining(","));
            }

            redisUtil.set("Roles:" + sysUser.getUsername(), code, 60 * 60);
            redisUtil.set("GrantedAuthority:" + sysUser.getUsername(), authority, 60 * 60);
        }

        return authority;
    }
}
