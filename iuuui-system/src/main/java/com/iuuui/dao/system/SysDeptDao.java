package com.iuuui.dao.system;

import com.iuuui.base.BaseDao;
import com.iuuui.common.dto.system.SysDeptTreeDTO;
import com.iuuui.domain.system.SysDept;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysDeptDao extends BaseDao<SysDept> {

    List<SysDeptTreeDTO> list();
}