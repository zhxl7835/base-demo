package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.dao.JsglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUserRole;
import com.basedemo02xtgl.basedemo02xtgl.service.JsglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name YhgkServiceImpl
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:26
 * @Version: 1.0
 */
@Service
public class JsglServiceImpl implements JsglService {
    @Autowired
    private JsglMapper jsglMapper;
    @Override
    public List<SysRole> getRolesByUserId(Long userId) {

        return jsglMapper.getRolesByUserId(userId);
    }

    @Override
    public List<SysRole> queryRoles(String name) {
        return jsglMapper.queryRoles(name);
    }

    @Override
    public Integer insertRoles(SysRole sysRole) {
        return jsglMapper.insertRoles(sysRole);
    }

    @Override
    public Integer updateRoles(SysRole sysRole) {
        return jsglMapper.updateRoles(sysRole);
    }

    @Override
    public Integer deleteRoles(Long id) {
        return jsglMapper.deleteRoles(id);
    }

    @Override
    public Integer deleteAllRoles(List ids) {
        return jsglMapper.deleteAllRoles(ids);
    }

    @Override
    public List<SysUserRole> queryRoleMenus(Long roleId) {
        return jsglMapper.queryRoleMenus(roleId);
    }
}
