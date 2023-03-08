package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysUserPassword;
import com.iuuui.service.system.SysUserPasswordService;
import com.iuuui.dao.system.SysUserPasswordDao;
import org.springframework.stereotype.Service;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysUserPasswordServiceImpl extends BaseServiceImpl<SysUserPassword> implements SysUserPasswordService {

    final SysUserPasswordDao dao;

    public SysUserPasswordServiceImpl(SysUserPasswordDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysUserPassword> getBaseDao() { return dao; }

}