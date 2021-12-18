package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CdglMapper {

    List<SysMenu> queryMenus();
    // 新增菜单信息
    Integer insertMenus(@Param("sysMenu")SysMenu sysMenu);
    // 修改菜单信息
    Integer updateMenus(@Param("sysMenu")SysMenu sysMenu);
    // 根据菜单名称获取父菜单ID
    Integer getParentIdByName(@Param("name")String name);
}
