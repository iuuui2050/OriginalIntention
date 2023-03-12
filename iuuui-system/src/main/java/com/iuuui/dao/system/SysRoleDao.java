package com.iuuui.dao.system;

import com.iuuui.base.BaseDao;
import com.iuuui.common.dto.system.SysRoleListDTO;
import com.iuuui.domain.system.SysRole;

import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysRoleDao extends BaseDao<SysRole> {

    List<SysRoleListDTO> listPage(Map params);

    Long count(Map params);
}