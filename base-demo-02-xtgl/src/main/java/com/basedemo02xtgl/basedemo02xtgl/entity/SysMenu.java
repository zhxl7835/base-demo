package com.basedemo02xtgl.basedemo02xtgl.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer parentId;
    private String name;
    private String perms;
    private Integer type;
    private String created;
    private String updated;
    private Integer state;

    private Boolean checked = false;

    private List<SysMenu> children = new ArrayList<>();

}
