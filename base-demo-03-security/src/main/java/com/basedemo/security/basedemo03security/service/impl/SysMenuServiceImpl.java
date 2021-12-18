package com.basedemo.security.basedemo03security.service.impl;

import com.basedemo.security.basedemo03security.dao.SysMenuMapper;
import com.basedemo.security.basedemo03security.entity.SysMenu;
import com.basedemo.security.basedemo03security.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getMenus(List roles) {

        return sysMenuMapper.getMenus(roles);

    }
}
