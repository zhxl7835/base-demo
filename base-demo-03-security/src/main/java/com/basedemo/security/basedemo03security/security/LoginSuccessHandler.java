package com.basedemo.security.basedemo03security.security;

import cn.hutool.json.JSONUtil;
import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.utils.JwtUtils;
import com.basedemo.security.basedemo03security.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zheng
 * @Description: 登录成功拦截器
 * @Date: 2021-12-12 1:29
 * @Version: 1.0
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		ServletOutputStream outputStream = response.getOutputStream();

		// 生成jwt，并放置到请求头中
		String jwt = jwtUtils.generateToken(authentication.getName());
		response.setHeader(jwtUtils.getHeader(), jwt);

		// zhxl登录成功返回token 和 用户角色和权限信息
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("token",jwt);
		map.put("access",StringUtils.tokenizeToStringArray((String)redisUtil.get("GrantedAuthority:" + authentication.getName()), ","));


		ResultData result = ResultData.succ(map);

		outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));

		outputStream.flush();
		outputStream.close();
	}

}
