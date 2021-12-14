package com.basedemo.security.basedemo03security.utils;

import java.util.UUID;

/**
 * @Name UUIDGenerator
 * @Description: TODO
 * @Author: zheng
 * @Date: 2021-11-26 10:01
 * @Version: 1.0
 */
public class UUIDGenerator {
    public UUIDGenerator() { }
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
