package com.basedemo.security.basedemo03security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.basedemo.security.basedemo03security.entity.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhengxiaolong
 * @since 2021-12-11
 */
public interface SysUserService extends IService<SysUser> {

	SysUser getByUsername(String username);

	String getUserAuthorityInfo(Long userId);

	void clearUserAuthorityInfo(String username);

	void clearUserAuthorityInfoByRoleId(Long roleId);

	void clearUserAuthorityInfoByMenuId(Long menuId);


}
