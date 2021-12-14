package com.basedemo.security.basedemo03security.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * @Author zhengxiaolong
 * @Date 2021-12-11
 */
@Data
public class BaseEntity implements Serializable {

	private Long id;
	private LocalDateTime created;
	private LocalDateTime updated;
	private Integer state;
}
