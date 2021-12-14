package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.dao.JsglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
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
}
