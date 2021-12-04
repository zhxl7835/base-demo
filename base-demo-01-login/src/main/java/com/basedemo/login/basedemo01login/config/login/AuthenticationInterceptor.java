package com.basedemo.login.basedemo01login.config.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.basedemo.login.basedemo01login.service.LoginService;
import com.basedemo01.login.common.basedemo01logincommon.vo.login.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Name AuthenticationInterceptor
 * @Description: 实现HandlerInterceptor接口  实现拦截还是放通的逻辑
 * @Author: zheng
 * @Date: 2021-11-29 13:19
 * @Version: 1.0
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;
    /*@Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                TbUser tbUser = testService.findUserById(userId);
                if (tbUser == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(tbUser.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有NoToken注释，有则跳过认证
        if (method.isAnnotationPresent(NoToken.class)) {
            System.out.println("NoToken--登录请求不需要token");
            NoToken noToken = method.getAnnotation(NoToken.class);
            if (noToken.required()) {
                return true;
            }
        }

        //没有NoToken注释的请求，需要验证token
        // 执行认证
        if (token == null) {
            throw new RuntimeException("无token，请重新登录");
        }
        System.out.println("token认证请求:"+httpServletRequest.getRequestURI()+"，token="+token);
        // 获取 token 中的 user id
        String userId;
        try {
            //userId = JWT.decode(token).getAudience().get(0);
            userId = TokenUtil.getTokenUserId();
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        TbUser tbUser = loginService.findUserById(userId);
        System.out.println("tbUser => id:"+tbUser.getId()+"    useername:"+tbUser.getUsername()+"    password:"+tbUser.getPassword());
        if (tbUser == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(tbUser.getPassword())).build();
        try {
            DecodedJWT jwt = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
