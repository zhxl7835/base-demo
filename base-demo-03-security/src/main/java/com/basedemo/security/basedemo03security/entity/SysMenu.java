package com.basedemo.security.basedemo03security.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    private Date created;
    private Date updated;
    private Integer state;

}
