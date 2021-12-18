package com.basedemo.security.basedemo03security.service;

import com.basedemo.security.basedemo03security.entity.SysMenu;

import java.util.List;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
public interface SysMenuService {
    /**
     * @Author: zheng
     * @Description: 根据角色列表获取用户菜单权限列表
     * @Date: 2021-12-13 16:35
     */
    List<SysMenu> getMenus(List roles);
}
