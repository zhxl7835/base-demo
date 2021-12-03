package com.basedemo.middle.basedemo01middle.dao;

import com.basedemo.common.basedemo01common.dto.Books;
import com.basedemo.common.basedemo01common.vo.TbTeachingMaterialVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMaintenanceMapper {
    List<TbTeachingMaterialVO> queryBooks(@Param("code")String code, @Param("name")String name, @Param("major")String major, @Param("grade") String grade);

    Integer insertBooks(@Param("books") Books books);

    Integer deleteBooks(@Param("books") Books books);

    void deleteAllBooks(@Param("ids") List ids);

    Integer updateBooks(@Param("books") Books books);
}
