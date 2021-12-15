package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.common.vo.UserRoles;
import com.basedemo02xtgl.basedemo02xtgl.dao.YhglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUser;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUserRole;
import com.basedemo02xtgl.basedemo02xtgl.service.YhglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name YhgkServiceImpl
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:26
 * @Version: 1.0
 */
@Service
public class YhglServiceImpl implements YhglService {

    @Autowired
    private YhglMapper yhglMapper;

    @Override
    public List<SysUser> queryUsers(String username) {
        return yhglMapper.queryUsers(username);
    }

    @Override
    public Integer deleteUsers(Long id) {
        return yhglMapper.deleteUsers(id);
    }

    @Override
    public Integer deleteAllUsers(List ids) {
        return yhglMapper.deleteAllUsers(ids);
    }

    @Override
    public Integer insertUsers(SysUser sysUser) {
        return yhglMapper.insertUsers(sysUser);
    }

    @Override
    public Integer updateUsers(SysUser sysUser) {
        return yhglMapper.updateUsers(sysUser);
    }

    @Override
    public void updateUserRoles(UserRoles userRoles) {
        Integer i = yhglMapper.deleteUserRoles(userRoles.getUserId());
        //menuData对象数据 转换为 menuData1 的List数据
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for (int j = 0; j < userRoles.getRoleId().length; j++) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userRoles.getUserId());
            sysUserRole.setRoleId(userRoles.getRoleId()[j]);
            sysUserRoleList.add(sysUserRole);
        }
        Integer j = yhglMapper.insertUserRoles(sysUserRoleList);
    }
}
