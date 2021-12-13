package com.basedemo.security.basedemo03security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.basedemo.security.basedemo03security.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
public interface SysRoleService extends IService<SysRole> {

	List<SysRole> listRolesByUserId(Long userId);

}
