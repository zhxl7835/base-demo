package com.basedemo.middle.basedemo01middle.service.impl;

import com.basedemo.common.basedemo01common.dto.Books;
import com.basedemo.common.basedemo01common.vo.TbTeachingMaterialVO;
import com.basedemo.middle.basedemo01middle.dao.BookMaintenanceMapper;
import com.basedemo.middle.basedemo01middle.service.BookMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name BookMaintenanceServicImpl
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-11-25 15:35
 * @Version: 1.0
 */
@Service
public class BookMaintenanceServicImpl implements BookMaintenanceService {
    @Autowired
    private BookMaintenanceMapper bookMaintenanceMapper;
    @Override
    public List<TbTeachingMaterialVO> queryBooks(String code, String name, String major, String grade) {

        return bookMaintenanceMapper.queryBooks(code, name, major, grade);
    }

    @Override
    public Integer insertBooks(Books books) {

        return bookMaintenanceMapper.insertBooks(books);
    }

    @Override
    public Integer deleteBooks(Books books) {
        return bookMaintenanceMapper.deleteBooks(books);
    }

    @Override
    public void deleteAllBooks(List ids) {
        bookMaintenanceMapper.deleteAllBooks(ids);
    }

    @Override
    public Integer updateBooks(Books books) {
        return bookMaintenanceMapper.updateBooks(books);
    }
}
