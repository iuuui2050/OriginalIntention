package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.domain.system.SysUserRole;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {

    void save(Long userId, List<Long> roleIds);

    List<Long> findRoleIds(Long userId);

    List<Long> findUserIds(Long roleId);

    List<SysUserRole> findByUserId(Long userId);

    List<SysUserRole> findByRoleId(Long roleId);

}