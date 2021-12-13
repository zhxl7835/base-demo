package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.common.basedemo02xtglcommon.dto.MenuData;
import com.basedemo02xtgl.common.basedemo02xtglcommon.dto.MenuData1;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbPowers;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;

import java.util.List;

public interface QxglService {
    /*查询*/
    List<TbUser> queryUsers();

    List<TbPowers> getAccess(String username);

    Integer deleteAllByUsername(String username);

    Integer insertAllByMenuId(List<MenuData1> menuData1List);
}
