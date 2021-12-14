package com.basedemo.security.basedemo03security.security;

import com.basedemo.security.basedemo03security.common.exception.CaptchaException;
import com.basedemo.security.basedemo03security.common.lang.Const;
import com.basedemo.security.basedemo03security.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author: zheng
 * @Description: 图片验证码校验拦截器
 * @Date: 2021-12-12 20:52
 * @Version: 1.0
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private LoginFailureHandler loginFailureHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

		String url = httpServletRequest.getRequestURI();

		if ("/login".equals(url) && httpServletRequest.getMethod().equals("POST")) {

			try{
				// 校验验证码
				validate(httpServletRequest);
			} catch (CaptchaException e) {

				// 交给认证失败处理器
				loginFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
			}
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	// 校验验证码逻辑
	private void validate(HttpServletRequest httpServletRequest) {

		String code = httpServletRequest.getParameter("code");
		String key = httpServletRequest.getParameter("key");

		// 为了测试
		/*key = "aaaaa";
		code = "11111";*/
		//zhxl
		if (StringUtils.isEmpty(code) || StringUtils.isEmpty(key)) {
			throw new CaptchaException("验证码错误");
		}

		if (!code.equals(redisUtil.hget(Const.CAPTCHA_KEY, key))) {
			throw new CaptchaException("验证码错误");
		}

		// 一次性使用
		redisUtil.hdel(Const.CAPTCHA_KEY, key);
	}
}
