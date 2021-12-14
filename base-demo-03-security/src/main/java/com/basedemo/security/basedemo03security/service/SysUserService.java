package com.basedemo.security.basedemo03security.service;

import com.basedemo.security.basedemo03security.entity.SysUser;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
public interface SysUserService {
    //根据用户名获取用户信息
    SysUser getByUsername(String username);
    //根据用户名获取用户信息
    String getUserAuthorityInfo(Long userId);
}
