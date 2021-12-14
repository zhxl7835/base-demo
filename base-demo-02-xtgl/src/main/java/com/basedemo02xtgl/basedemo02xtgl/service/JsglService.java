package com.basedemo02xtgl.basedemo02xtgl.service;

import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;

import java.util.List;

public interface JsglService {
    // 获取角色信息
    List<SysRole> getRolesByUserId(Long userId);


}
