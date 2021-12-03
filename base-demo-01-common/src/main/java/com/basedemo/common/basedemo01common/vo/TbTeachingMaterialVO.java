package com.basedemo.common.basedemo01common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Name TbTeachingMaterialVO
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-11-25 15:30
 * @Version: 1.0
 */
@Data
public class TbTeachingMaterialVO implements Serializable {
    private String id;
    private String code;
    private String name;
    private String press;
    private String author;
    private Date pdate;
    private String uprice;
    private String major;
    private String grade;
    private String delflag;
}
