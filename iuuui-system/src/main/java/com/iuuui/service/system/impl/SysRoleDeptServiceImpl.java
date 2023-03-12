package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.domain.system.SysRoleDept;
import com.iuuui.domain.system.SysRoleMenu;
import com.iuuui.service.system.SysRoleDeptService;
import com.iuuui.dao.system.SysRoleDeptDao;
import com.iuuui.util.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iuuui
 * @since 2023-03-12 14:27
 */
@Service
public class SysRoleDeptServiceImpl extends BaseServiceImpl<SysRoleDept> implements SysRoleDeptService {

    final SysRoleDeptDao dao;

    public SysRoleDeptServiceImpl(SysRoleDeptDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysRoleDept> getBaseDao() { return dao; }

    @Override
    public void save(Long roleId, List<Long> deptIds) {
        Assert.notNull(roleId, "roleId argument must not be null");
        List<SysRoleDept> roleDepts = this.findByRoleId(roleId);
        // del
        for (SysRoleDept roleDept : roleDepts) {
            if (!deptIds.contains(roleDept.getDeptId()))
                super.deleteM(roleDept.getId());
        }
        // add
        for (Long deptId : deptIds) {
            boolean add = true;
            for (SysRoleDept roleDept : roleDepts) {
                if (roleDept.getDeptId().equals(deptId)) {
                    add = false;
                }
            }
            if (add) {
                this.create(roleId, deptId);
            }
        }
    }

    private void create(Long roleId, Long deptId) {
        SysRoleDept query = new SysRoleDept();
        query.setRoleId(roleId);
        query.setDeptId(deptId);
        super.createM(query);
    }

    @Override
    public List<Long> findDeptIds(Long roleId) {
        List<SysRoleDept> roleDepts = this.findByRoleId(roleId);
        if (CollectionUtils.isEmpty(roleDepts))
            return CollectionUtils.newList();
        return roleDepts.stream().map(SysRoleDept::getDeptId).collect(Collectors.toList());

    }

    @Override
    public List<SysRoleDept> findByRoleId(Long roleId) {
        Assert.notNull(roleId, "roleId argument must not be null");
        SysRoleDept query = new SysRoleDept();
        query.setRoleId(roleId);
        return super.selectM(query);
    }
}