package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.common.dto.system.SysMenuTreeDTO;
import com.iuuui.common.param.system.SysMenuFormParam;
import com.iuuui.domain.system.SysMenu;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-11 15:50
 */
public interface SysMenuService extends BaseService<SysMenu> {

    void save(SysMenuFormParam param);

    void status(Long id);

    void delete(Long id);

    List<SysMenuTreeDTO> findTree();

}