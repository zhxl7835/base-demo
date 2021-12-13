package com.basedemo.security.basedemo03security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.basedemo.security.basedemo03security.common.dto.SysMenuDto;
import com.basedemo.security.basedemo03security.entity.SysMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 我的公众号：MarkerHub
 * @since 2021-04-05
 */
public interface SysMenuService extends IService<SysMenu> {

	List<SysMenuDto> getCurrentUserNav();

	List<SysMenu> tree();

}
