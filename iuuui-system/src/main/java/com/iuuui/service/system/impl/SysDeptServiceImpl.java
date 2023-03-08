package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysDept;
import com.iuuui.service.system.SysDeptService;
import com.iuuui.dao.system.SysDeptDao;
import org.springframework.stereotype.Service;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements SysDeptService {

    final SysDeptDao dao;

    public SysDeptServiceImpl(SysDeptDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysDept> getBaseDao() { return dao; }

}