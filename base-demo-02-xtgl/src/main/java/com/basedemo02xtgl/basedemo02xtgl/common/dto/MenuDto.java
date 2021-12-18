package com.basedemo02xtgl.basedemo02xtgl.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Name MenuDto
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-19 2:47
 * @Version: 1.0
 */
@Data
public class MenuDto implements Serializable {
    private Integer id;
    private String parentName;
    private String name;
    private String perms;
    private Integer type;
    private Integer state;
}
