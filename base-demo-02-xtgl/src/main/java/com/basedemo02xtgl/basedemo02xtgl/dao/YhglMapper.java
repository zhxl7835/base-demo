package com.basedemo02xtgl.basedemo02xtgl.dao;

import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YhglMapper {
    List<TbUser> queryUsers(@Param("username")String username);

    Integer insertUsers(@Param("tbUser") TbUser tbUser);

    Integer deleteUsers(@Param("tbUser") TbUser tbUser);

    void deleteAllUsers(@Param("ids") List ids);

    Integer updateUsers(@Param("tbUser") TbUser tbUser);

}
