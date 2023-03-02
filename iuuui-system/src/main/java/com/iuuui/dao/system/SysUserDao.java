package com.iuuui.dao.system;

import com.iuuui.base.BaseDao;
import com.iuuui.domain.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author iuuui
 * @since 2023-03-02 22:35
 */
@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {

}