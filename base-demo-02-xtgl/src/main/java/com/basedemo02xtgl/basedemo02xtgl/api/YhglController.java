package com.basedemo02xtgl.basedemo02xtgl.api;

import com.basedemo02xtgl.basedemo02xtgl.common.ResultData;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRole;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysUser;
import com.basedemo02xtgl.basedemo02xtgl.service.JsglService;
import com.basedemo02xtgl.basedemo02xtgl.service.YhglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Name YhglController
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/xtgl/yhgl")
public class YhglController {
    @Autowired
    private YhglService yhglService;

    @Autowired
    private JsglService jsglService;

    @PostMapping("/queryUsers")
    public ResultData queryUsers(@RequestParam String username) {
        try {
            // 获取用户信息
            List<SysUser> list1 = yhglService.queryUsers(username);
            // 根据UserId 获取角色信息
            for (int i = 0; i < list1.size(); i++) {
                List<SysRole> list2 = jsglService.getRolesByUserId(list1.get(i).getId());
                String roles = list2.stream().map(SysRole::getName).collect(Collectors.joining(","));
                list1.get(i).setRoles(roles);
            }
            return ResultData.succ("查询用户信息成功",list1);
        } catch (Exception e) {
            return ResultData.fail("获取用户信息时报错");
        }
    }
    @PostMapping("/deleteUsers")
    public ResultData deleteUsers(@RequestParam Long id) {
        try {
            Integer i = yhglService.deleteUsers(id);
            return ResultData.succ("删除用户成功",null);
        } catch (Exception e) {
            return ResultData.fail("删除用户失败");
        }
    }
    @PostMapping("/deleteAllUsers")
    public ResultData deleteAllUsers(@RequestParam List ids) {
        try {
            Integer i = yhglService.deleteAllUsers(ids);
            return ResultData.succ("批量删除用户成功",null);
        } catch (Exception e) {
            return ResultData.fail("批量删除用户失败");
        }
    }

    @PostMapping("/insertUsers")
    public ResultData insertUsers(@RequestBody SysUser sysUser) {
        try {
            Integer i = yhglService.insertUsers(sysUser);
            return ResultData.succ("新增用户成功",null);
        } catch (Exception e) {
            return ResultData.fail("新增用户失败");
        }
    }

    @PostMapping("/updateUsers")
    public ResultData updateUsers(@RequestBody SysUser sysUser) {
        try {
            Integer i = yhglService.updateUsers(sysUser);
            return ResultData.succ("修改用户信息成功",null);
        } catch (Exception e) {
            return ResultData.fail("修改用户信息失败");
        }
    }

}
