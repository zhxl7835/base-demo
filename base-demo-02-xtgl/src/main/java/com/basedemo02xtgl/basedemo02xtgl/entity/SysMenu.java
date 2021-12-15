package com.basedemo02xtgl.basedemo02xtgl.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long parentId;
    private String name;
    private String path;
    private String perms;
    private String component;
    private Integer type;
    private String icon;
    private Integer orderNum;
    private String created;
    private String updated;
    private Integer state;

}
