package com.basedemo.security.basedemo03security.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultData implements Serializable {

	private int code;
	private String msg;
	private Object data;

	public static ResultData succ(Object data) {
		return succ(200, "操作成功", data);
	}

	public static ResultData succ(int code, String msg, Object data) {
		ResultData r = new ResultData();
		r.setCode(code);
		r.setMsg(msg);
		r.setData(data);
		return r;
	}

	public static ResultData fail(String msg) {
		return fail(400, msg, null);
	}

	public static ResultData fail(int code, String msg, Object data) {
		ResultData r = new ResultData();
		r.setCode(code);
		r.setMsg(msg);
		r.setData(data);
		return r;
	}

}
