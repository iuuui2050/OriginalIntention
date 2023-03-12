package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.common.dto.system.SysDeptTreeDTO;
import com.iuuui.common.param.system.SysDeptFormParam;
import com.iuuui.domain.system.SysDept;

import java.util.List;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysDeptService extends BaseService<SysDept> {

    /**
     * 保存部门最上一级，即“公司”
     */
    void saveTopLevel(String name);

    void save(SysDeptFormParam param);

    List<SysDept> findByParentId(Long parentId);

    Long findCountByParentId(Long parentId);

    SysDept findByName(String name);

    SysDept findByCode(String code);

    void status(Long id);

    void delete(Long id);

    SysDeptTreeDTO findTree();
}