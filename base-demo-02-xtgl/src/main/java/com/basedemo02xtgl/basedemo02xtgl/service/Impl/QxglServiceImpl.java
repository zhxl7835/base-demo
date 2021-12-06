package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.dao.QxglMapper;
import com.basedemo02xtgl.basedemo02xtgl.dao.YhglMapper;
import com.basedemo02xtgl.basedemo02xtgl.service.QxglService;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbPowers;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;
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
    public List<TbUser> queryUsers() {
        return qxglMapper.queryUsers();
    }

    @Override
    public List<TbPowers> getAccess(String username) {
        return qxglMapper.getAccess(username);
    }
}
