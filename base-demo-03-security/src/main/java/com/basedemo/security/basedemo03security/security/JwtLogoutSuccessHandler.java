package com.basedemo.security.basedemo03security.security;

import cn.hutool.json.JSONUtil;
import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author: zheng
 * @Description: 系统退出操作拦截器
 * @Date: 2021-12-12 20:53
 * @Version: 1.0
 */
@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {

	@Autowired
	JwtUtils jwtUtils;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}

		response.setContentType("application/json;charset=UTF-8");
		ServletOutputStream outputStream = response.getOutputStream();

		response.setHeader(jwtUtils.getHeader(), "");

		ResultData result = ResultData.succ("");

		outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));

		outputStream.flush();
		outputStream.close();
	}
}
