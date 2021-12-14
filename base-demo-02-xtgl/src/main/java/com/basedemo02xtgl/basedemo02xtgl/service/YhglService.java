package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysUser;

import java.util.List;

public interface YhglService {
    // 获取用户信息
    List<SysUser> queryUsers(String username);
    // 根据userId删除用户信息
    Integer deleteUsers(Long id);
    // 用户新增
    Integer insertUsers(SysUser sysUser);


}
