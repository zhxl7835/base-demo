package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.basedemo02xtgl.common.dto.RoleMenus;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRoleMenu;

import java.util.List;

public interface JsglService {
    // 获取角色信息
    List<SysRole> getRolesByUserId(Integer userId);

    // 根据角色名称获取角色信息
    List<SysRole> queryRoles(String name);


    // 新增角色信息
    Integer insertRoles(SysRole sysRole);

    // 修改角色信息
    Integer updateRoles(SysRole sysRole);

    // 根据roleId删除角色信息
    Integer deleteRoles(Integer id);

    // 根据roleId批量删除角色信息
    Integer deleteAllRoles(List ids);

    // 根据角色Id获取该角色菜单
    List<SysRoleMenu> queryRoleMenus(Integer roleId);

    // 修改角色菜单权限
    void updateRoleMenus(RoleMenus roleMenus);
}
