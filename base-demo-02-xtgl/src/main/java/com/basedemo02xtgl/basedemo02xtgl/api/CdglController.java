package com.basedemo02xtgl.basedemo02xtgl.api;

import com.basedemo02xtgl.basedemo02xtgl.common.ResultData;
import com.basedemo02xtgl.basedemo02xtgl.common.dto.MenuDto;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysMenu;
import com.basedemo02xtgl.basedemo02xtgl.service.CdglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Name YhglController
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/xtgl/cdgl")
public class CdglController {

    @Autowired
    private CdglService cdglService;

    @PostMapping("/queryMenus")
    public ResultData queryMenus() {
        try {
            List<SysMenu> list = cdglService.getMenus();
            return ResultData.succ("获取菜单信息成功",list);
        } catch (Exception e) {
            return ResultData.fail("获取菜单信息失败");
        }
    }

    @PostMapping("/insertMenus")
    public ResultData insertMenus(@RequestBody MenuDto menuDto) {
        try {
            cdglService.insertMenus(menuDto);
            return ResultData.succ("新增菜单信息成功");
        } catch (Exception e) {
            return ResultData.fail("新增菜单信息失败");
        }
    }

    @PostMapping("/updateMenus")
    public ResultData updateMenus(@RequestBody MenuDto menuDto) {
        try {
            cdglService.updateMenus(menuDto);
            return ResultData.succ("修改菜单信息成功");
        } catch (Exception e) {
            return ResultData.fail("修改菜单信息失败");
        }
    }

}
