package com.basedemo.security.basedemo03security.service.impl;


import com.basedemo.security.basedemo03security.dao.SysRoleMapper;
import com.basedemo.security.basedemo03security.entity.SysRole;
import com.basedemo.security.basedemo03security.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public List<SysRole> getRoles(Long userId) {
        return sysRoleMapper.getRoles(userId);
    }
}
