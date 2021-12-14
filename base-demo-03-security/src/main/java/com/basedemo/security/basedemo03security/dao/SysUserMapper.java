package com.basedemo.security.basedemo03security.dao;

import com.basedemo.security.basedemo03security.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Mapper
public interface SysUserMapper {

	SysUser getByUsername(@Param("username") String username);

	SysUser selectById(@Param("id") Long id);
}
