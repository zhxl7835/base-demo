package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.basedemo02xtgl.common.dto.MenuDto;
import com.basedemo02xtgl.basedemo02xtgl.common.dto.Menus;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysMenu;

import java.util.List;

public interface CdglService {

    // 获取菜单信息1
    List<Menus> queryMenus(Integer roleId);
    // 获取菜单信息2
    List<SysMenu> getMenus();
    // 新增菜单信息
    void insertMenus(MenuDto menuDto);
    // 修改菜单信息
    void updateMenus(MenuDto menuDto);

}
