package com.basedemo.security.basedemo03security.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String code;
    private String remark;
    private Date created;
    private Date updated;
    private Integer state;


}
