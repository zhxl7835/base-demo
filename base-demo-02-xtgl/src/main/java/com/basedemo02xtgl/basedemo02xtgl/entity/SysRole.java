package com.basedemo02xtgl.basedemo02xtgl.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysRole implements Serializable {

    private Integer id;
    private String name;
    private String code;
    private String remark;
    private String created;
    private String updated;
    private Integer state;


}
