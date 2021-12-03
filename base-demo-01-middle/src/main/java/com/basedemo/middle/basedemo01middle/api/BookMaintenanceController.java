package com.basedemo.middle.basedemo01middle.api;


import com.basedemo.common.basedemo01common.dto.Books;
import com.basedemo.common.basedemo01common.resultEntity.ResultCadData;
import com.basedemo.common.basedemo01common.utils.UUIDGenerator;
import com.basedemo.common.basedemo01common.vo.TbTeachingMaterialVO;
import com.basedemo.middle.basedemo01middle.service.BookMaintenanceService;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/BookMaintenance")
public class BookMaintenanceController {

    @Autowired
    private BookMaintenanceService bookMaintenanceService;


    @PostMapping(value = "/queryBooks")
    public ResultCadData queryBooks(@RequestBody Books books) {
        ResultCadData<List> resultCadData = new ResultCadData();
        if("全部".equals(books.getMajor())){
            books.setMajor("");
        }
        if("全部".equals(books.getGrade())){
            books.setGrade("");
        }
        List<TbTeachingMaterialVO> list = bookMaintenanceService.queryBooks(books.getCode(), books.getName(), books.getMajor(), books.getGrade());
        resultCadData.setMsg("查询成功");
        resultCadData.setData(list);
        resultCadData.setCode(200);
        return resultCadData;
    }

    @PostMapping(value = "/insertBooks")
    public ResultCadData insertBooks(@RequestBody Books books) {
        ResultCadData<Object> resultCadData = new ResultCadData();
        books.setId(UUIDGenerator.getUUID());
        Integer i = bookMaintenanceService.insertBooks(books);
        if(i == 1){
            resultCadData.setMsg("新增教材信息成功");
            resultCadData.setData(null);
            resultCadData.setCode(200);
            return resultCadData;
        }else{
            resultCadData.setMsg("新增教材信息失败");
            resultCadData.setData(null);
            resultCadData.setCode(500);
            return resultCadData;
        }
    }

    @PostMapping(value = "/deleteBooks")
    public ResultCadData deleteBooks(@RequestBody Books books) {
        ResultCadData<Map> resultCadData = new ResultCadData();
        Integer i = bookMaintenanceService.deleteBooks(books);
        if(i == 1){
            resultCadData.setMsg("删除成功");
            resultCadData.setData(null);
            resultCadData.setCode(200);
        }
        return resultCadData;
    }
    @PostMapping(value = "/deleteAllBooks")
    public ResultCadData deleteAllBooks(@RequestParam String ids) {
        ResultCadData<Map> resultCadData = new ResultCadData();
        List list = Arrays.asList(ids.split(","));
        bookMaintenanceService.deleteAllBooks(list);
        resultCadData.setMsg("批量删除成功");
        resultCadData.setData(null);
        resultCadData.setCode(200);
        return resultCadData;
    }
    @PostMapping(value = "/updateBooks")
    public ResultCadData updateBooks(@RequestBody Books books) {
        ResultCadData<Object> resultCadData = new ResultCadData();
        Integer i = bookMaintenanceService.updateBooks(books);
        if(i == 1){
            resultCadData.setMsg("修改教材信息成功");
            resultCadData.setData(null);
            resultCadData.setCode(200);
            return resultCadData;
        }else{
            resultCadData.setMsg("修改教材信息失败");
            resultCadData.setData(null);
            resultCadData.setCode(500);
            return resultCadData;
        }
    }
}