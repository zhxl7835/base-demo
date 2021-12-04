package com.basedemo01.login.common.basedemo01logincommon.resultEntity;

import lombok.Data;

/**
 * @Name ResultCadData
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-11-28 1:38
 * @Version: 1.0
 */
@Data
public class ResultCadData<T> {
    public int code;
    public String msg;
    public T data;
}
