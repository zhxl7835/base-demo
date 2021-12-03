package com.basedemo.middle.basedemo01middle.dao;

import com.basedemo.common.basedemo01common.vo.login.TbPowers;
import com.basedemo.common.basedemo01common.vo.login.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {
    TbUser loginCheck(@Param("username")String username);
    TbUser findUserById(@Param("id")String id);
    List<TbPowers> getPowers(@Param("userid")String userid, @Param("username")String username);
}
