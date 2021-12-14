package com.basedemo.security.basedemo03security.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.basedemo.security.basedemo03security.common.lang.Const;
import com.basedemo.security.basedemo03security.common.lang.ResultData;
import com.basedemo.security.basedemo03security.service.SysUserService;
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
import java.util.Random;

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
	@Autowired
	SysUserService sysUserService;

	@GetMapping("captcha")
	public ResultData captcha() throws IOException {

		String key = UUID.randomUUID().toString();
		//谷歌图片验证码
		//String code = producer.createText();
		//图片验证码换成5位数字
		Random random = new Random();
		int ran = random.nextInt(99999);
		if(ran<10000){
			ran = ran + 10000;
		}
		String code = ran+"";
		// 为了测试
		//key = "aaaaa";
		code = "11111";

		BufferedImage image = producer.createImage(code);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", outputStream);

		BASE64Encoder encoder = new BASE64Encoder();
		String str = "data:image/jpeg;base64,";

		String base64Img = str + encoder.encode(outputStream.toByteArray());

		redisUtil.hset(Const.CAPTCHA_KEY, key, code, 120);

		ResultData resultData = ResultData.succ("",
				MapUtil.builder()
						.put("key", key)
						.put("captchaImg", base64Img)
						.build()

		);
		return resultData;
	}
}
