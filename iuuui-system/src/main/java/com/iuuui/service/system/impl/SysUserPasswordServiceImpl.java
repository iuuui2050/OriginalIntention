package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.constants.ExceptionEnum;
import com.iuuui.domain.system.SysUserPassword;
import com.iuuui.exception.BusinessException;
import com.iuuui.service.system.SysUserPasswordService;
import com.iuuui.dao.system.SysUserPasswordDao;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    @Override
    public void save(Long userId, String password, String salt) {
        Assert.notNull(userId, "userId argument must not be null");
        Assert.hasLength(password, "password it must not be null or empty");
        Assert.hasLength(salt, "salt it must not be null or empty");
        SysUserPassword query = this.findByUserId(userId);
        if (query == null) query = new SysUserPassword();
        query.setUserId(userId);
        query.setPassword(password);
        query.setSalt(salt);
        super.createOrUpdate(query);
    }

    @Override
    public SysUserPassword findByUserId(Long userId) {
        Assert.notNull(userId, "userId argument must not be null");
        SysUserPassword query = new SysUserPassword();
        query.setUserId(userId);
        return super.selectOne(query);
    }
}