package com.basedemo02xtgl.basedemo02xtgl.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysUser implements Serializable {
     private Long id;
     private String username;
     private String password;
     private String avatar;
     private String email;
     private String xm;
     private String sfzh;
     private String phone;
     private Date lastLogin;
     private Date created;
     private Date updated;
     private Integer state;

     private String roles;
}
