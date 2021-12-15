package com.basedemo02xtgl.basedemo02xtgl.common.vo;

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
public class UserRoles implements Serializable {
    private Long userId;
    private Long[] roleId;
    private String username;
}
