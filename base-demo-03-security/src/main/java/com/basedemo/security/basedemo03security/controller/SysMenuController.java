package com.basedemo.security.basedemo03security.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.basedemo.security.basedemo03security.common.dto.SysMenuDto;
import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.entity.SysMenu;
import com.basedemo.security.basedemo03security.entity.SysRoleMenu;
import com.basedemo.security.basedemo03security.entity.SysUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: zheng
 * @Description: //菜单接口
 * @Date: 2021-12-12 15:41
 * @Param:
 * @return:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

	/**
	 * 用户当前用户的菜单和权限信息
	 * @param principal
	 * @return
	 */
	@GetMapping("/nav")
	public ResultData nav(Principal principal) {
		SysUser sysUser = sysUserService.getByUsername(principal.getName());

		// 获取权限信息
		String authorityInfo = sysUserService.getUserAuthorityInfo(sysUser.getId());// ROLE_admin,ROLE_normal,sys:user:list,....
		String[] authorityInfoArray = StringUtils.tokenizeToStringArray(authorityInfo, ",");

		// 获取导航栏信息
		List<SysMenuDto> navs = sysMenuService.getCurrentUserNav();

		return ResultData.succ(MapUtil.builder()
				.put("authoritys", authorityInfoArray)
				.put("nav", navs)
				.map()
		);
	}

	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('sys:menu:list')")
	public ResultData info(@PathVariable(name = "id") Long id) {
		return ResultData.succ(sysMenuService.getById(id));
	}

	@GetMapping("/list")
	@PreAuthorize("hasAuthority('sys:menu:list')")
	public ResultData list() {

		List<SysMenu> menus = sysMenuService.tree();
		return ResultData.succ(menus);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('sys:menu:save')")
	public ResultData save(@Validated @RequestBody SysMenu sysMenu) {

		sysMenu.setCreated(LocalDateTime.now());

		sysMenuService.save(sysMenu);
		return ResultData.succ(sysMenu);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('sys:menu:update')")
	public ResultData update(@Validated @RequestBody SysMenu sysMenu) {

		sysMenu.setUpdated(LocalDateTime.now());

		sysMenuService.updateById(sysMenu);

		// 清除所有与该菜单相关的权限缓存
		sysUserService.clearUserAuthorityInfoByMenuId(sysMenu.getId());
		return ResultData.succ(sysMenu);
	}

	@PostMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('sys:menu:delete')")
	public ResultData delete(@PathVariable("id") Long id) {

		int count = sysMenuService.count(new QueryWrapper<SysMenu>().eq("parent_id", id));
		if (count > 0) {
			return ResultData.fail("请先删除子菜单");
		}

		// 清除所有与该菜单相关的权限缓存
		sysUserService.clearUserAuthorityInfoByMenuId(id);

		sysMenuService.removeById(id);

		// 同步删除中间关联表
		sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("menu_id", id));
		return ResultData.succ("");
	}
}
