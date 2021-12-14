package com.basedemo.security.basedemo03security.controller;

import com.basedemo.security.basedemo03security.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	RedisUtil redisUtil;
	/**
	 * 获取页面
	 * @return
	 */
	/*public Page getPage() {
		int current = ServletRequestUtils.getIntParameter(request, "cuurent", 1);
		int size = ServletRequestUtils.getIntParameter(request, "size", 10);

		return new Page(current, size);
	}
*/
}
