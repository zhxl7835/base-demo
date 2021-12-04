package com.basedemo.login.basedemo01login.service;

import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbPowers;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;

import java.util.List;


public interface LoginService {
    public TbUser loginCheck(String username);
    public TbUser findUserById(String id);
    List<TbPowers> getPowers(String userid, String username);
}
