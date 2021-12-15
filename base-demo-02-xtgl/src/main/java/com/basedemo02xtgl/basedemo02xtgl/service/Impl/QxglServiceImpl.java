package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.dao.QxglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysMenu;
import com.basedemo02xtgl.basedemo02xtgl.service.QxglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name YhgkServiceImpl
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:26
 * @Version: 1.0
 */
@Service
public class QxglServiceImpl implements QxglService {

    @Autowired
    private QxglMapper qxglMapper;

    @Override
    public List<SysMenu> queryMenus() {

        return qxglMapper.queryMenus();
    }

}
