package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysUser;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YhglMapper {
    List<SysUser> queryUsers(@Param("username") String username);

    Integer deleteUsers(@Param("id") Long id);

    Integer deleteAllUsers(@Param("ids") List ids);

    Integer insertUsers(@Param("sysUser") SysUser sysUser);

    Integer updateUsers(@Param("sysUser") SysUser sysUser);

    Integer deleteUserRoles(@Param("UserId") Long UserId);

    Integer insertUserRoles(@Param("sysUserRoleList") List<SysUserRole> sysUserRoleList);
}
