package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QxglMapper {

    List<SysMenu> queryMenus();

}
