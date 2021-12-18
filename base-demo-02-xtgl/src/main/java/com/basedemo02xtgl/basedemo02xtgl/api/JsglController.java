package com.basedemo02xtgl.basedemo02xtgl.api;

import com.basedemo02xtgl.basedemo02xtgl.common.ResultData;
import com.basedemo02xtgl.basedemo02xtgl.common.dto.RoleMenus;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.service.JsglService;
import com.basedemo02xtgl.basedemo02xtgl.service.CdglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name YhglController
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/xtgl/jsgl")
public class JsglController {

    @Autowired
    private JsglService jsglService;

    @Autowired
    private CdglService cdglService;

    @PostMapping("/queryRoles")
    public ResultData queryRoles(@RequestParam String name) {
        try {
            List<SysRole> list = jsglService.queryRoles(name);
            return ResultData.succ("",list);
        } catch (Exception e) {
            return ResultData.fail("获取用户信息时报错");
        }
    }

    @PostMapping("/insertRoles")
    public ResultData insertRoles(@RequestBody SysRole sysRole) {
        try {
            Integer i = jsglService.insertRoles(sysRole);
            return ResultData.succ("新增角色信息成功");
        } catch (Exception e) {
            return ResultData.fail("新增角色信息失败");
        }
    }

    @PostMapping("/updateRoles")
    public ResultData updateRoles(@RequestBody SysRole sysRole) {
        try {
            Integer i = jsglService.updateRoles(sysRole);
            return ResultData.succ("修改角色信息成功");
        } catch (Exception e) {
            return ResultData.fail("修改角色信息失败");
        }
    }

    @PostMapping("/deleteRoles")
    public ResultData deleteRoles(@RequestParam Integer id) {
        try {
            Integer i = jsglService.deleteRoles(id);
            return ResultData.succ("删除角色成功",null);
        } catch (Exception e) {
            return ResultData.fail("删除角色失败");
        }
    }
    @PostMapping("/deleteAllRoles")
    public ResultData deleteAllRoles(@RequestParam List ids) {
        try {
            Integer i = jsglService.deleteAllRoles(ids);
            return ResultData.succ("批量删除角色成功",null);
        } catch (Exception e) {
            return ResultData.fail("批量删除角色失败");
        }
    }

    @PostMapping("/queryMenus")
    public ResultData queryMenus(@RequestParam Integer roleId) {
        try {
            Map map = new HashMap<String,Object>();
            List list1 = cdglService.queryMenus(roleId);//获取全部菜单列表
            //List list2 = jsglService.queryRoleMenus(roleId);//根据角色ID获取当前角色菜单列表

            map.put("list1",list1);
            //map.put("list2",list2);
            return ResultData.succ(map);
        } catch (Exception e) {
            return ResultData.fail("获取菜单列表出错");
        }
    }
    @PostMapping("/updateRoleMenus")
    public ResultData updateRoleMenus(@RequestBody RoleMenus roleMenus) {
        try {
            System.out.println(roleMenus);
            jsglService.updateRoleMenus(roleMenus);
            return ResultData.succ("修改角色菜单权限c成功");
        } catch (Exception e) {
            return ResultData.fail("修改角色菜单权限失败");
        }
    }

}
