package com.basedemo.middle.basedemo01middle.service;

import com.basedemo.common.basedemo01common.dto.Books;
import com.basedemo.common.basedemo01common.vo.TbTeachingMaterialVO;

import java.util.List;

public interface BookMaintenanceService {
    /*查询*/
    List<TbTeachingMaterialVO> queryBooks(String code, String name, String major, String grade);
    /*新增*/
    Integer insertBooks(Books books);
    /*删除*/
    Integer deleteBooks(Books books);
    /*批量删除*/
    void deleteAllBooks(List ids);
    /*修改*/
    Integer updateBooks(Books books);

}
