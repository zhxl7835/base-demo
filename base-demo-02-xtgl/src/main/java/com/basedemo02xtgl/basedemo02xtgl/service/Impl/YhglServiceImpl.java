package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.dao.YhglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUser;
import com.basedemo02xtgl.basedemo02xtgl.service.YhglService;
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
public class YhglServiceImpl implements YhglService {

    @Autowired
    private YhglMapper yhglMapper;

    @Override
    public List<SysUser> queryUsers(String username) {
        return yhglMapper.queryUsers(username);
    }

    @Override
    public Integer deleteUsers(Long id) {
        return yhglMapper.deleteUsers(id);
    }

    @Override
    public Integer deleteAllUsers(List ids) {
        return yhglMapper.deleteAllUsers(ids);
    }

    @Override
    public Integer insertUsers(SysUser sysUser) {
        return yhglMapper.insertUsers(sysUser);
    }

    @Override
    public Integer updateUsers(SysUser sysUser) {
        return yhglMapper.updateUsers(sysUser);
    }
}
