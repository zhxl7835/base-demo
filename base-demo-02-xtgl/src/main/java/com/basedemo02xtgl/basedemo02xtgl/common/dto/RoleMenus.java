package com.basedemo02xtgl.basedemo02xtgl.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Name UserRoles
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-15 14:13
 * @Version: 1.0
 */
@Data
public class RoleMenus implements Serializable {
    private Integer roleId;
    private Integer[] menuId;
}
