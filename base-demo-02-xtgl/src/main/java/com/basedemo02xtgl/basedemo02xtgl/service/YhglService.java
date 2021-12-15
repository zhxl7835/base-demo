package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.basedemo02xtgl.common.vo.UserRoles;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUser;

import java.util.List;

public interface YhglService {

    // 获取用户信息
    List<SysUser> queryUsers(String username);

    // 根据userId删除用户信息
    Integer deleteUsers(Long id);

    // 根据userId批量删除用户信息
    Integer deleteAllUsers(List  ids);

    // 用户新增
    Integer insertUsers(SysUser sysUser);

    // 用户修改
    Integer updateUsers(SysUser sysUser);

    // 修改用户角色
    void updateUserRoles(UserRoles userRoles);
}
