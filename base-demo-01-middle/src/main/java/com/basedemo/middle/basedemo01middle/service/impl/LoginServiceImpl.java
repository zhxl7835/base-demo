package com.basedemo.middle.basedemo01middle.service.impl;

import com.basedemo.common.basedemo01common.vo.login.TbPowers;
import com.basedemo.common.basedemo01common.vo.login.TbUser;
import com.basedemo.middle.basedemo01middle.dao.LoginMapper;
import com.basedemo.middle.basedemo01middle.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public TbUser loginCheck(String username) {
        TbUser tbUser = loginMapper.loginCheck(username);
        return tbUser;
    }

    @Override
    public TbUser findUserById(String id) {
        TbUser tbUser = loginMapper.findUserById(id);
        return tbUser;
    }

    @Override
    public List<TbPowers> getPowers(String userid, String username) {
        List<TbPowers> list = loginMapper.getPowers(userid,username);
        return list;
    }
}
