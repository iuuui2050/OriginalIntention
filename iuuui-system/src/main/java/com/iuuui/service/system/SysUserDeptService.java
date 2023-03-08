package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.domain.system.SysUserDept;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysUserDeptService extends BaseService<SysUserDept> {

    void save(Long userId, List<Long> deptIds);

    List<Long> findDeptIds(Long userId);

    List<Long> findUserIds(Long deptId);

    List<SysUserDept> findByUserId(Long userId);

    List<SysUserDept> findByDeptId(Long deptId);

}