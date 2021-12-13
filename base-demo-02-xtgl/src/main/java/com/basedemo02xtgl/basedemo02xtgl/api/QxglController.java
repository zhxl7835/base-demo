package com.basedemo02xtgl.basedemo02xtgl.api;

import com.basedemo02xtgl.basedemo02xtgl.service.QxglService;
import com.basedemo02xtgl.basedemo02xtgl.service.YhglService;
import com.basedemo02xtgl.common.basedemo02xtglcommon.dto.MenuData;
import com.basedemo02xtgl.common.basedemo02xtglcommon.dto.MenuData1;
import com.basedemo02xtgl.common.basedemo02xtglcommon.resultEntity.ResultCadData;
import com.basedemo02xtgl.common.basedemo02xtglcommon.utils.UUIDGenerator;
import com.basedemo02xtgl.common.basedemo02xtglcommon.vo.*;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping(value = "/xtgl/qxgl")
public class QxglController {
    @Autowired
    private QxglService qxglService;

    @PostMapping("/queryUsers")
    public ResultCadData queryUsers() {
        ResultCadData<Grandpa[]> resultCadData = new ResultCadData();
        List<TbUser> list = qxglService.queryUsers();

        Grandpa[] grandpaArray = new Grandpa[1];
        Grandpa grandpa = new Grandpa();

        Parent parent1 = new Parent(); //超级管理员
        Parent parent2 = new Parent(); //管理员
        Parent parent3 = new Parent(); //普通用户

        List<Parent> listParent = new ArrayList<>();

        List<Son> listSon1 = new ArrayList<>(); //超级管理员
        List<Son> listSon2 = new ArrayList<>(); //管理员
        List<Son> listSon3 = new ArrayList<>(); //普通用户

        for (int i = 0; i < list.size(); i++) {
            if("超级管理员".equals(list.get(i).getRole())){
                Son son = new Son();
                son.setUsername(list.get(i).getUsername());
                son.setTitle(list.get(i).getXm());
                son.setUserid(list.get(i).getId());
                listSon1.add(son);
            } else if("管理员".equals(list.get(i).getRole())){
                Son son = new Son();
                son.setUsername(list.get(i).getUsername());
                son.setTitle(list.get(i).getXm());
                son.setUserid(list.get(i).getId());
                listSon2.add(son);
            } else if("普通用户".equals(list.get(i).getRole())){
                Son son = new Son();
                son.setUsername(list.get(i).getUsername());
                son.setTitle(list.get(i).getXm());
                son.setUserid(list.get(i).getId());
                listSon3.add(son);
            }
        }

        parent1.setTitle("超级管理员");
        parent1.setChildren(listSon1);
        parent2.setTitle("管理员");
        parent2.setChildren(listSon2);
        parent3.setTitle("普通用户");
        parent3.setChildren(listSon3);

        listParent.add(parent1);
        listParent.add(parent2);
        listParent.add(parent3);

        grandpa.setChildren(listParent);
        grandpaArray[0] = grandpa;

        resultCadData.setMsg("查询成功");
        resultCadData.setCode(200);
        resultCadData.setData(grandpaArray);
        return resultCadData;
    }
    @PostMapping(value = "/getAccess")
    public ResultCadData getAccess(@RequestBody TbUser tbUser) {
        ResultCadData resultCadData = new ResultCadData();
        List<TbPowers> list = qxglService.getAccess(tbUser.getUsername());
        resultCadData.setMsg("获取用户："+tbUser.getUsername()+"菜单权限列表成功");
        resultCadData.setCode(200);
        resultCadData.setData(list);
        return resultCadData;
    }
    @PostMapping(value = "/saveMenus")
    public ResultCadData saveMenus(@RequestBody MenuData menuData) {
        ResultCadData resultCadData = new ResultCadData();
        //删除tb_powers表中当前用户的权限列表
        Integer i = qxglService.deleteAllByUsername(menuData.getUsername());
        //新增权限列表
        //menuData对象数据 转换为 menuData1 的List数据
        List<MenuData1> menuData1List = new ArrayList<>();
        for (int j = 0; j < menuData.getMenuid().length; j++) {
            MenuData1 menuData1 = new MenuData1();
            menuData1.setUserid(menuData.getUserid());
            menuData1.setUsername(menuData.getUsername());
            menuData1.setMenuid(menuData.getMenuid()[j]);
            menuData1List.add(menuData1);
        }
        Integer j = qxglService.insertAllByMenuId(menuData1List);

        resultCadData.setMsg("修改菜单权限成功");
        resultCadData.setCode(200);
        resultCadData.setData(null);
        return resultCadData;
    }
}
