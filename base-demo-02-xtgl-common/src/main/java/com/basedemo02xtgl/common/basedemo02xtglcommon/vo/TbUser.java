package com.basedemo02xtgl.common.basedemo02xtglcommon.vo;

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
    private String delflag;
}
