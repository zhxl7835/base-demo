package com.basedemo02xtgl.common.basedemo02xtglcommon.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Name MenuData
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-07 16:27
 * @Version: 1.0
 */
@Data
public class MenuData implements Serializable {
    private String[] menuid;
    private String userid;
    private String username;
}
