package com.basedemo01.login.common.basedemo01logincommon.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Name QueryBooks
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-11-25 21:50
 * @Version: 1.0
 */
@Data
public class Books implements Serializable {
    private String id;
    private String code;
    private String name;
    private String press;
    private String author;
    private Date pdate;
    private String uprice;
    private String major;
    private String grade;
}
