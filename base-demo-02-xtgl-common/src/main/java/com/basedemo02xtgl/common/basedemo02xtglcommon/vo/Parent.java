package com.basedemo02xtgl.common.basedemo02xtglcommon.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Name Grandpa
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-06 19:43
 * @Version: 1.0
 */
@Data
public class Parent implements Serializable {
    private String title;
    private Boolean expand = false;
    private List<Son> children;
}
