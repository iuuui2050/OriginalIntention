package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.common.param.system.SysRoleFormParam;
import com.iuuui.common.param.system.SysRoleSearchParam;
import com.iuuui.domain.system.SysRole;

import java.util.Map;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysRoleService extends BaseService<SysRole> {

    void save(SysRoleFormParam param);

    void status(Long id);

    void delete(Long id);

    SysRole findByCode(String code);

    SysRole findByName(String name);

    Map listPage(SysRoleSearchParam param);

}