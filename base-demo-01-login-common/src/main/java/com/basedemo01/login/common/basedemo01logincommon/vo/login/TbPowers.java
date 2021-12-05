package com.basedemo01.login.common.basedemo01logincommon.vo.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @Name TbPowers
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-03 8:38
 * @Version: 1.0
 */
@Data
public class TbPowers implements Serializable {
    private String userid;
    private String username;
    private int menuid;
}
