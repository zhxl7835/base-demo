package com.basedemo.security.basedemo03security.dao;


import com.basedemo.security.basedemo03security.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Mapper
public interface SysRoleMapper{

    List<SysRole> getRoles(@Param("userId")Long userId);

}
