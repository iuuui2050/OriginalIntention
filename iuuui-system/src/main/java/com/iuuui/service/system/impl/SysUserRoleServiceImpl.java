package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysUserRole;
import com.iuuui.service.system.SysUserRoleService;
import com.iuuui.dao.system.SysUserRoleDao;
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
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole> implements SysUserRoleService {

    final SysUserRoleDao dao;

    public SysUserRoleServiceImpl(SysUserRoleDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysUserRole> getBaseDao() { return dao; }

    @Override
    public void save(Long userId, List<Long> roleIds) {
        Assert.notNull(userId, "userId argument must not be null");
        List<SysUserRole> userRoles = this.findByUserId(userId);
        // del
        for (SysUserRole userRole : userRoles) {
            if (roleIds.contains(userRole.getRoleId())) {
                continue;
            }
            super.deleteM(userRole.getId());
        }
        // add
        for (Long roleId : roleIds) {
            boolean add = true;
            for (SysUserRole userRole : userRoles) {
                if (roleId.equals(userRole.getRoleId())) {
                    add = false;
                }
            }
            if (add) {
                this.create(userId, roleId);
            }
        }
    }

    private void create(Long userId, Long roleId) {
        SysUserRole query = new SysUserRole();
        query.setUserId(userId);
        query.setRoleId(roleId);
        super.createM(query);
    }

    @Override
    public List<Long> findRoleIds(Long userId) {
        Assert.notNull(userId, "userId argument must not be null");
        List<SysUserRole> userRoles = this.findByUserId(userId);
        if (CollectionUtils.isEmpty(userRoles))
            return CollectionUtils.newList();
        return userRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
    }

    @Override
    public List<Long> findUserIds(Long roleId) {
        Assert.notNull(roleId, "roleId argument must not be null");
        List<SysUserRole> userRoles = this.findByRoleId(roleId);
        if (CollectionUtils.isEmpty(userRoles))
            return CollectionUtils.newList();
        return userRoles.stream().map(SysUserRole::getUserId).collect(Collectors.toList());
    }

    @Override
    public List<SysUserRole> findByUserId(Long userId) {
        Assert.notNull(userId, "userId argument must not be null");
        SysUserRole query = new SysUserRole();
        query.setUserId(userId);
        return super.selectM(query);
    }

    @Override
    public List<SysUserRole> findByRoleId(Long roleId) {
        Assert.notNull(roleId, "roleId argument must not be null");
        SysUserRole query = new SysUserRole();
        query.setRoleId(roleId);
        return super.selectM(query);
    }
}