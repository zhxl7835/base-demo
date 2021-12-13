package com.basedemo.security.basedemo03security.common.exception;

import com.basedemo.security.basedemo03security.common.lang.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	//

	// 实体校验异常捕获
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResultData handler(MethodArgumentNotValidException e) {

		BindingResult result = e.getBindingResult();
		ObjectError objectError = result.getAllErrors().stream().findFirst().get();

		log.error("实体校验异常：----------------{}", objectError.getDefaultMessage());
		return ResultData.fail(objectError.getDefaultMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResultData handler(IllegalArgumentException e) {
		log.error("Assert异常：----------------{}", e.getMessage());
		return ResultData.fail(e.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = RuntimeException.class)
	public ResultData handler(RuntimeException e) {
		log.error("运行时异常：----------------{}", e.getMessage());
		return ResultData.fail(e.getMessage());
	}

}
