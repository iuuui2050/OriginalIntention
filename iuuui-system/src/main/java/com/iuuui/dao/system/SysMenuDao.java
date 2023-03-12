package com.iuuui.dao.system;

import com.iuuui.base.BaseDao;
import com.iuuui.common.dto.system.SysMenuTreeDTO;
import com.iuuui.domain.system.SysMenu;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-11 15:50
 */
public interface SysMenuDao extends BaseDao<SysMenu> {

    List<SysMenuTreeDTO> list();
}