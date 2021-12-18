package com.basedemo02xtgl.basedemo02xtgl.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;
    private Integer roleId;
    private Integer menuId;


}
