package com.basedemo01.login.common.basedemo01logincommon.vo.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbUser implements Serializable {
    private String id;
    private String username;
    private String password;
    private String xm;
    private String sfzh;
    private String email;
    private String role;
    private String[] access;
}
