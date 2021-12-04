package com.basedemo.login.basedemo01login.service.impl;



import com.basedemo.login.basedemo01login.dao.LoginMapper;
import com.basedemo.login.basedemo01login.service.LoginService;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbPowers;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;
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
