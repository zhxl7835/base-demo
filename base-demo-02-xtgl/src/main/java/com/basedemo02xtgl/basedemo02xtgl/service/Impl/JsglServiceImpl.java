package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.common.dto.RoleMenus;
import com.basedemo02xtgl.basedemo02xtgl.dao.JsglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRoleMenu;
import com.basedemo02xtgl.basedemo02xtgl.service.JsglService;
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
public class JsglServiceImpl implements JsglService {
    @Autowired
    private JsglMapper jsglMapper;
    @Override
    public List<SysRole> getRolesByUserId(Integer userId) {

        return jsglMapper.getRolesByUserId(userId);
    }

    @Override
    public List<SysRole> queryRoles(String name) {
        return jsglMapper.queryRoles(name);
    }

    @Override
    public Integer insertRoles(SysRole sysRole) {
        return jsglMapper.insertRoles(sysRole);
    }

    @Override
    public Integer updateRoles(SysRole sysRole) {
        return jsglMapper.updateRoles(sysRole);
    }

    @Override
    public Integer deleteRoles(Integer id) {
        return jsglMapper.deleteRoles(id);
    }

    @Override
    public Integer deleteAllRoles(List ids) {
        return jsglMapper.deleteAllRoles(ids);
    }

    @Override
    public List<SysRoleMenu> queryRoleMenus(Integer roleId) {

        return jsglMapper.queryRoleMenus(roleId);
    }

    @Override
    public void updateRoleMenus(RoleMenus roleMenus) {
        //roleMenus对象数据 转换为 RoleMenus 的List数据
        List<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
        for (int j = 0; j < roleMenus.getMenuId().length; j++) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleMenus.getRoleId());
            sysRoleMenu.setMenuId(roleMenus.getMenuId()[j]);
            sysRoleMenuList.add(sysRoleMenu);
        }
        //根据roleID删除角色菜单列表
        Integer i = jsglMapper.deleteRoleMenus(roleMenus.getRoleId());
        //新增角色菜单列表
        Integer j = jsglMapper.insertRoleMenus(sysRoleMenuList);
    }
}
