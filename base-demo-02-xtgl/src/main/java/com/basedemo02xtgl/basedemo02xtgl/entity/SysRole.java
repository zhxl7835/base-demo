package com.basedemo02xtgl.basedemo02xtgl.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysRole implements Serializable {

    private Long id;
    private String name;
    private String code;
    private String remark;
    private Date created;
    private Date updated;
    private Integer state;


}
