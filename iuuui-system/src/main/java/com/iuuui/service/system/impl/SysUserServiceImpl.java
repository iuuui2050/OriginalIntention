package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysUser;
import com.iuuui.service.system.SysUserService;
import com.iuuui.dao.system.SysUserDao;
import org.springframework.stereotype.Service;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    final SysUserDao dao;

    public SysUserServiceImpl(SysUserDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysUser> getBaseDao() { return dao; }

}