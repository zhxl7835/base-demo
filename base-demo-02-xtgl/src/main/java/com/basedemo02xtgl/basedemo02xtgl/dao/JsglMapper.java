package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JsglMapper {

    List<SysRole> getRolesByUserId(@Param("userId") Integer userId);

    List<SysRole> queryRoles(@Param("name") String name);

    Integer insertRoles(@Param("sysRole")SysRole sysRole);

    Integer updateRoles(@Param("sysRole")SysRole sysRole);

    Integer deleteRoles(@Param("id")Integer id);

    Integer deleteAllRoles(@Param("ids")List ids);

    List<SysRoleMenu> queryRoleMenus(@Param("roleId")Integer roleId);

    Integer deleteRoleMenus(@Param("roleId")Integer roleId);

    Integer insertRoleMenus(@Param("lists") List<SysRoleMenu> lists);
}
