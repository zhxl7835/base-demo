package com.basedemo.security.basedemo03security.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.basedemo.security.basedemo03security.common.lang.Const;
import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.entity.SysUser;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
/**
 * @Author: zheng
 * @Description: //获取验证码图片接口
 * @Date: 2021-12-12 15:40
 * @Param:
 * @return:
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/")
public class AuthController extends BaseController{

	@Autowired
	Producer producer;

	@GetMapping("captcha")
	public ResultData captcha() throws IOException {

		String key = UUID.randomUUID().toString();
		String code = producer.createText();

/*		// 为了测试
		key = "aaaaa";
		code = "11111";*/

		BufferedImage image = producer.createImage(code);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", outputStream);

		BASE64Encoder encoder = new BASE64Encoder();
		String str = "data:image/jpeg;base64,";

		String base64Img = str + encoder.encode(outputStream.toByteArray());

		redisUtil.hset(Const.CAPTCHA_KEY, key, code, 120);

		ResultData resultData = ResultData.succ(
				MapUtil.builder()
						.put("key", key)
						.put("captchaImg", base64Img)
						.build()

		);
		return resultData;
	}

	/**
	 * 获取用户信息接口
	 * @param principal
	 * @return
	 */
	/*@GetMapping("/sys/userInfo")
	public ResultData userInfo(Principal principal) {

		SysUser sysUser = sysUserService.getByUsername(principal.getName());

		return ResultData.succ(MapUtil.builder()
				.put("id", sysUser.getId())
				.put("username", sysUser.getUsername())
				.put("avatar", sysUser.getAvatar())
				.put("created", sysUser.getCreated())
				.map()
		);
	}*/


}
