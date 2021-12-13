package com.basedemo.login.basedemo01login.config.login.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.basedemo.login.basedemo01login.config.login.TokenUtil;
import com.basedemo.login.basedemo01login.constants.ApiConstants;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;
import com.basedemo.login.basedemo01login.config.login.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Name TokenServiceImpl
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-11-29 13:34
 * @Version: 1.0
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(TbUser user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        /*token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));*/
        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(ApiConstants.KEY));
        System.out.println("登录请求，生成token="+token);
        return token;
    }
}
