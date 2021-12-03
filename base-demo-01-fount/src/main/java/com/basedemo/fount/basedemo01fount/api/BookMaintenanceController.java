package com.basedemo.fount.basedemo01fount.api;

import com.basedemo.fount.basedemo01fount.feignclient.BookMaintenanceFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/hello")
public class BookMaintenanceController {
    public static final String PAYMENT_URL = "http://base-demo-fount";

    @Resource
    private BookMaintenanceFeignService testServiceService;

    @RequestMapping(value = "/hello")
    public String getHello() {
        System.out.println("123");
        System.out.println("123");
        System.out.println("123");
        System.out.println("123");
       /* String sfzh=testServiceService.getHello();*/
        return "base-demo-fount";
    }
}
