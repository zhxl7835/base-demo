package com.basedemo.middle.basedemo01middle.config.login;

import com.basedemo.common.basedemo01common.vo.login.TbUser;


public interface TokenService {
    String getToken(TbUser user);
}
