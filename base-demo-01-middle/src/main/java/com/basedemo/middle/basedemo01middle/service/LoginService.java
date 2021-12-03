package com.basedemo.middle.basedemo01middle.service;

import com.basedemo.common.basedemo01common.vo.login.TbPowers;
import com.basedemo.common.basedemo01common.vo.login.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LoginService {
    public TbUser loginCheck(String username);
    public TbUser findUserById(String id);
    List<TbPowers> getPowers(String userid, String username);
}
