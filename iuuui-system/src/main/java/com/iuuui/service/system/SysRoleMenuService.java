package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.domain.system.SysRoleMenu;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-11 15:25
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenu> {

    void save(Long roleId, List<Long> menuIds);

    List<Long> findMenuIds(Long roleId);

    List<Long> findRoleIds(Long menuId);

    List<SysRoleMenu> findByRoleId(Long roleId);

    List<SysRoleMenu> findByMenuId(Long menuId);

}