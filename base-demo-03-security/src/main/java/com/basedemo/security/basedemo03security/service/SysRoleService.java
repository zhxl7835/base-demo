package com.basedemo.security.basedemo03security.service;

import com.basedemo.security.basedemo03security.entity.SysRole;

import java.util.List;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
public interface SysRoleService{
    /**
     * @Author: zheng
     * @Description: 根据用户ID获取用户角色
     * @Date: 2021-12-13 16:35
     */
    List<SysRole> getRoles(Long userId);
}
