package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbPowers;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QxglMapper {
    List<TbUser> queryUsers();
    List<TbPowers> getAccess(@Param("username")String username);
}