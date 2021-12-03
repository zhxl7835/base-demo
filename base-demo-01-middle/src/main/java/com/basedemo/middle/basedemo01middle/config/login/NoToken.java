package com.basedemo.middle.basedemo01middle.config.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于不需要token验证的请求 如：登录请求
 * @author zhengxiaolong
 * @date 2021-11-29
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoToken {
    boolean required() default true;
}
