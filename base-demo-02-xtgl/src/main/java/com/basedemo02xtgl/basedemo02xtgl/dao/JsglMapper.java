package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JsglMapper {

    List<SysRole> getRolesByUserId(@Param("userId") Long userId);

    List<SysRole> queryRoles(@Param("name") String name);

    Integer insertRoles(@Param("sysRole")SysRole sysRole);

    Integer updateRoles(@Param("sysRole")SysRole sysRole);

    Integer deleteRoles(@Param("id")Long id);

    Integer deleteAllRoles(@Param("ids")List ids);

    List<SysUserRole> queryRoleMenus(@Param("roleId")Long roleId);
}
