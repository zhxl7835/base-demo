package com.basedemo02xtgl.basedemo02xtgl.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name RoleMenus
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-15 16:17
 * @Version: 1.0
 */
@Data
public class Menus implements Serializable {

    private String title;
    private Boolean expand = true; //默认展开

    private Boolean checked;

    private Integer id;
    private Integer parentId;
    private String name;
    private String perms;
    private Integer type;
    private String created;
    private String updated;
    private Integer state;

    private List<Menus> children = new ArrayList<>();
}
