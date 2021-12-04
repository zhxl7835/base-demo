package com.basedemo.login.basedemo01login.dao;

import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbPowers;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {
    TbUser loginCheck(@Param("username")String username);
    TbUser findUserById(@Param("id")String id);
    List<TbPowers> getPowers(@Param("userid")String userid, @Param("username")String username);
}
