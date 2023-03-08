package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysUserDept;
import com.iuuui.service.system.SysUserDeptService;
import com.iuuui.dao.system.SysUserDeptDao;
import com.iuuui.util.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysUserDeptServiceImpl extends BaseServiceImpl<SysUserDept> implements SysUserDeptService {

    final SysUserDeptDao dao;

    public SysUserDeptServiceImpl(SysUserDeptDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysUserDept> getBaseDao() { return dao; }

    @Override
    public void save(Long userId, List<Long> deptIds) {
        Assert.notNull(userId, "userId argument must be null");
        if (CollectionUtils.isEmpty(deptIds)) return;
        List<SysUserDept> userDepts = this.findByUserId(userId);
        // del
        for (SysUserDept userDept : userDepts) {
            if (deptIds.contains(userDept.getDeptId())) {
                continue;
            }
            super.deleteM(userDept.getId());
        }
        // add
        for (Long deptId : deptIds) {
            boolean add = true;
            for (SysUserDept userDept : userDepts) {
                if (deptId.equals(userDept.getDeptId())) {
                    add = false;
                }
            }
            if (add) {
                this.create(userId, deptId);
            }
        }
    }

    private void create(Long userId, Long deptId) {
        SysUserDept query = new SysUserDept();
        query.setUserId(userId);
        query.setDeptId(deptId);
        super.createM(query);
    }

    @Override
    public List<Long> findDeptIds(Long userId) {
        Assert.notNull(userId, "userId argument must be null");
        List<SysUserDept> userDepts = this.findByUserId(userId);
        if (CollectionUtils.isEmpty(userDepts))
            return CollectionUtils.newList();
        return userDepts.stream().map(SysUserDept::getDeptId).collect(Collectors.toList());
    }

    @Override
    public List<Long> findUserIds(Long deptId) {
        Assert.notNull(deptId, "deptId argument must be null");
        List<SysUserDept> userDepts = this.findByDeptId(deptId);
        if (CollectionUtils.isEmpty(userDepts))
            return CollectionUtils.newList();
        return userDepts.stream().map(SysUserDept::getUserId).collect(Collectors.toList());
    }

    @Override
    public List<SysUserDept> findByUserId(Long userId) {
        Assert.notNull(userId, "userId argument must be null");
        SysUserDept query = new SysUserDept();
        query.setUserId(userId);
        return super.selectM(query);
    }

    @Override
    public List<SysUserDept> findByDeptId(Long deptId) {
        Assert.notNull(deptId, "deptId argument must be null");
        SysUserDept query = new SysUserDept();
        query.setDeptId(deptId);
        return super.selectM(query);
    }
}