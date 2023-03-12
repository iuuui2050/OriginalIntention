package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.domain.system.SysRoleDept;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-12 14:27
 */
public interface SysRoleDeptService extends BaseService<SysRoleDept> {

    void save(Long roleId, List<Long> deptIds);

    List<Long> findDeptIds(Long roleId);

    List<SysRoleDept> findByRoleId(Long roleId);

}