package com.basedemo02xtgl.basedemo02xtgl.service.Impl;

import com.basedemo02xtgl.basedemo02xtgl.common.dto.MenuDto;
import com.basedemo02xtgl.basedemo02xtgl.common.dto.Menus;
import com.basedemo02xtgl.basedemo02xtgl.dao.CdglMapper;
import com.basedemo02xtgl.basedemo02xtgl.dao.JsglMapper;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysMenu;
import com.basedemo02xtgl.basedemo02xtgl.entity.SysRoleMenu;
import com.basedemo02xtgl.basedemo02xtgl.service.CdglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name YhgkServiceImpl
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:26
 * @Version: 1.0
 */
@Service
public class CdglServiceImpl implements CdglService {

    @Autowired
    private CdglMapper cdglMapper;

    @Autowired
    private JsglMapper jsglMapper;

    @Override
    public List<Menus> queryMenus(Integer roleId) {
        List<SysMenu> menus = cdglMapper.queryMenus();
        List<SysRoleMenu> list = jsglMapper.queryRoleMenus(roleId);//根据角色ID获取当前角色菜单列表
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < menus.size(); j++) {
                if( list.get(i).getMenuId() == menus.get(j).getId() ){
                    menus.get(j).setChecked(true);
                }
            }
        }


        // 转成树状结构
        List<SysMenu> listTree = buildTreeMenu(menus);
        // 实体转DTO
        return convert(listTree);
    }

    @Override
    public List<SysMenu> getMenus() {
        List<SysMenu> menus = cdglMapper.queryMenus();
        List<SysMenu> listTree = buildTreeMenu(menus);
        return listTree;
    }

    @Override
    public void insertMenus(MenuDto menuDto) {
        // 获取父菜单id
        Integer parentId = 0;
        if("添加或修改目录不需要选中上级菜单".equals(menuDto.getParentName())){
            parentId = cdglMapper.getParentIdByName(menuDto.getParentName());
        }
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(menuDto.getId());
        sysMenu.setParentId(parentId);
        sysMenu.setName(menuDto.getName());
        sysMenu.setPerms(menuDto.getPerms());
        sysMenu.setState(menuDto.getState());
        sysMenu.setType(menuDto.getType());
        cdglMapper.insertMenus(sysMenu);
    }

    @Override
    public void updateMenus(MenuDto menuDto) {
        // 获取父菜单id
        Integer parentId = 0;
        if("添加或修改目录不需要选中上级菜单".equals(menuDto.getParentName())){
            parentId = cdglMapper.getParentIdByName(menuDto.getParentName());
        }
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(menuDto.getId());
        sysMenu.setParentId(parentId);
        sysMenu.setName(menuDto.getName());
        sysMenu.setPerms(menuDto.getPerms());
        sysMenu.setState(menuDto.getState());
        sysMenu.setType(menuDto.getType());
        cdglMapper.updateMenus(sysMenu);
    }

    public List<SysMenu> buildTreeMenu(List<SysMenu> menus) {

        List<SysMenu> finalMenus = new ArrayList<>();

        // 先各自寻找到各自的子节点
        for (SysMenu menu : menus) {

            for (SysMenu e : menus) {
                if (menu.getId() == e.getParentId()) {
                    menu.getChildren().add(e);
                }
            }

            // 提取出父节点
            if (menu.getParentId() == 0) {
                finalMenus.add(menu);
            }
        }

        return finalMenus;
    }
    public List<Menus> convert(List<SysMenu> menuTree) {
        List<Menus> menus = new ArrayList<>();

        menuTree.forEach(m -> {
            Menus dto = new Menus();

            dto.setTitle(m.getName());
            dto.setChecked(m.getChecked());
            dto.setId(m.getId());
            dto.setName(m.getName());
            dto.setPerms(m.getPerms());
            dto.setParentId(m.getParentId());
            dto.setType(m.getType());
            dto.setCreated(m.getCreated());
            dto.setUpdated(m.getUpdated());
            dto.setState(m.getState());

            if (m.getChildren().size() > 0) {
                /*dto.setChecked(false);*/
                // 子节点调用当前方法进行再次转换
                dto.setChildren(convert(m.getChildren()));
            }

            menus.add(dto);
        });

        return menus;
    }

}
