package com.basedemo.login.basedemo01login.config.login;


import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;

public interface TokenService {
    String getToken(TbUser user);
}
