package com.basedemo.login.basedemo01login.config.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Name InterceptorConfig
 * @Description: 拦截器配置 用于拦截前端请求 实现   WebMvcConfigurer
 * @Author: zheng
 * @Date: 2021-11-29 13:17
 * @Version: 1.0
 */
@Configuration
public class InterceptorConfig implements  WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();// 自己写的拦截器
    }
    //省略其他重写方法

}
