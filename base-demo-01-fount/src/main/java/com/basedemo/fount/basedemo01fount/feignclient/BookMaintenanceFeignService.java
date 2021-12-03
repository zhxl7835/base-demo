package com.basedemo.fount.basedemo01fount.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient(value = "base-demo-middle")
@RequestMapping(value = "/hello")
public interface BookMaintenanceFeignService {
    @PostMapping(value = "/hello")
    String getHello();

}
