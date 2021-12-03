package com.basedemo.common.basedemo01common.vo.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbUser implements Serializable {
    private String id;
    private String username;
    private String password;
    private String name;
    private String sfzh;
    private String email;
    private int[] roles;
}
