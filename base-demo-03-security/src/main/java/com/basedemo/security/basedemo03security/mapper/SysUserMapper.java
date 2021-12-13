package com.basedemo.security.basedemo03security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basedemo.security.basedemo03security.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhengxiaolong
 * @since 2021-12-11
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

	List<Long> getNavMenuIds(Long userId);

	List<SysUser> listByMenuId(Long menuId);
}
