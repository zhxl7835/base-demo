package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.dao.YhglMapper;
import com.basedemo02xtgl.basedemo02xtgl.service.YhglService;
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
public class YhgkServiceImpl implements YhglService {
    @Autowired
    private YhglMapper yhglMapper;

    @Override
    public List<TbUser> queryUsers(String username) {

        return yhglMapper.queryUsers(username);
    }

    @Override
    public Integer insertUsers(TbUser tbUser) {

        return yhglMapper.insertUsers(tbUser);
    }

    @Override
    public Integer deleteUsers(TbUser tbUser) {
        return yhglMapper.deleteUsers(tbUser);
    }

    @Override
    public void deleteAllUsers(List ids) {
        yhglMapper.deleteAllUsers(ids);
    }

    @Override
    public Integer updateUsers(TbUser tbUser) {
        return yhglMapper.updateUsers(tbUser);
    }
}
