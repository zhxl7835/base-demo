package com.basedemo02xtgl.basedemo02xtgl.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class SysUser implements Serializable {
     private Integer id;
     private String username;
     private String password;
     private String avatar;
     private String email;
     private String xm;
     private String sfzh;
     private String phone;
     private String lastLogin;
     private String created;
     private String updated;
     private Integer state;

     private String roles;
}
