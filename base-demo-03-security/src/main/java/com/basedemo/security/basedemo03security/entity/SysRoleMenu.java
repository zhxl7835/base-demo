package com.basedemo.security.basedemo03security.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private Long roleId;
    private Long menuId;


}
