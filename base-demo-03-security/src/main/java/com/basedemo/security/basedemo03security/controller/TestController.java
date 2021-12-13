package com.basedemo.security.basedemo03security.controller;


import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name YhglController
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-12-05 1:25
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/")
public class TestController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/hello")
    public Object hello() {

        return sysUserService.list();
    }
    @RequestMapping("/index")
    public String index() {

        return "index";
    }
    @RequestMapping("get_info")
    public ResultData get_info(){
        ResultData resultCadData = new ResultData();
        resultCadData.setCode(200);
        resultCadData.setMsg("成功");
        resultCadData.setData(null);
        return resultCadData;
    }

}
