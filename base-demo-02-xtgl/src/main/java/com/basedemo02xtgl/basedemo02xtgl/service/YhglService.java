package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.TbUser;

import java.util.List;

public interface YhglService {
    /*查询*/
    List<TbUser> queryUsers(String username);
    /*新增*/
    Integer insertUsers(TbUser tbUser);
    /*删除*/
    Integer deleteUsers(TbUser tbUser);
    /*批量删除*/
    void deleteAllUsers(List ids);
    /*修改*/
    Integer updateUsers(TbUser tbUser);
}
