package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysRole;
import com.iuuui.service.system.SysRoleService;
import com.iuuui.dao.system.SysRoleDao;
import org.springframework.stereotype.Service;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    final SysRoleDao dao;

    public SysRoleServiceImpl(SysRoleDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysRole> getBaseDao() { return dao; }

}