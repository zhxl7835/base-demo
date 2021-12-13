package com.basedemo.security.basedemo03security.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.basedemo.security.basedemo03security.common.lang.Const;
import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.entity.SysRole;
import com.basedemo.security.basedemo03security.entity.SysRoleMenu;
import com.basedemo.security.basedemo03security.entity.SysUserRole;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zheng
 * @Description: 角色接口
 * @Date: 2021-12-12 15:41
 * @Param:
 * @return:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

	/*@PreAuthorize("hasAuthority('sys:role:list')")
	@GetMapping("/info/{id}")
	public ResultData info(@PathVariable("id") Long id) {

		SysRole sysRole = sysRoleService.getById(id);

		// 获取角色相关联的菜单id
		List<SysRoleMenu> roleMenus = sysRoleMenuService.list(new QueryWrapper<SysRoleMenu>().eq("role_id", id));
		List<Long> menuIds = roleMenus.stream().map(p -> p.getMenuId()).collect(Collectors.toList());

		sysRole.setMenuIds(menuIds);
		return ResultData.succ(sysRole);
	}

	@PreAuthorize("hasAuthority('sys:role:list')")
	@GetMapping("/list")
	public ResultData list(String name) {

		Page<SysRole> pageData = sysRoleService.page(getPage(),
				new QueryWrapper<SysRole>()
						.like(StrUtil.isNotBlank(name), "name", name)
		);

		return ResultData.succ(pageData);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('sys:role:save')")
	public ResultData save(@Validated @RequestBody SysRole sysRole) {

		sysRole.setCreated(LocalDateTime.now());
		sysRole.setState(Const.STATUS_ON);

		sysRoleService.save(sysRole);
		return ResultData.succ(sysRole);
	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('sys:role:update')")
	public ResultData update(@Validated @RequestBody SysRole sysRole) {

		sysRole.setUpdated(LocalDateTime.now());

		sysRoleService.updateById(sysRole);

		// 更新缓存
		sysUserService.clearUserAuthorityInfoByRoleId(sysRole.getId());

		return ResultData.succ(sysRole);
	}

	@PostMapping("/delete")
	@PreAuthorize("hasAuthority('sys:role:delete')")
	@Transactional
	public ResultData info(@RequestBody Long[] ids) {

		sysRoleService.removeByIds(Arrays.asList(ids));

		// 删除中间表
		sysUserRoleService.remove(new QueryWrapper<SysUserRole>().in("role_id", ids));
		sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().in("role_id", ids));

		// 缓存同步删除
		Arrays.stream(ids).forEach(id -> {
			// 更新缓存
			sysUserService.clearUserAuthorityInfoByRoleId(id);
		});

		return ResultData.succ("");
	}

	@Transactional
	@PostMapping("/perm/{roleId}")
	@PreAuthorize("hasAuthority('sys:role:perm')")
	public ResultData info(@PathVariable("roleId") Long roleId, @RequestBody Long[] menuIds) {

		List<SysRoleMenu> sysRoleMenus = new ArrayList<>();

		Arrays.stream(menuIds).forEach(menuId -> {
			SysRoleMenu roleMenu = new SysRoleMenu();
			roleMenu.setMenuId(menuId);
			roleMenu.setRoleId(roleId);

			sysRoleMenus.add(roleMenu);
		});

		// 先删除原来的记录，再保存新的
		sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId));
		sysRoleMenuService.saveBatch(sysRoleMenus);

		// 删除缓存
		sysUserService.clearUserAuthorityInfoByRoleId(roleId);

		return ResultData.succ(menuIds);
	}*/

}
