package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.common.constants.system.SysRoleDataScopeEnum;
import com.iuuui.common.dto.system.SysRoleListDTO;
import com.iuuui.common.param.system.SysRoleFormParam;
import com.iuuui.common.param.system.SysRoleSearchParam;
import com.iuuui.constants.ExceptionEnum;
import com.iuuui.domain.system.SysRole;
import com.iuuui.exception.BusinessException;
import com.iuuui.service.system.SysRoleDeptService;
import com.iuuui.service.system.SysRoleMenuService;
import com.iuuui.service.system.SysRoleService;
import com.iuuui.dao.system.SysRoleDao;
import com.iuuui.util.Page;
import com.iuuui.util.ReflectUtil;
import com.iuuui.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    final SysRoleDao dao;

    public SysRoleServiceImpl(SysRoleDao dao, SysRoleMenuService sysRoleMenuService, SysRoleDeptService sysRoleDeptService) {
        this.dao = dao;
        this.sysRoleMenuService = sysRoleMenuService;
        this.sysRoleDeptService = sysRoleDeptService;
    }

    @Override
    public BaseDao<SysRole> getBaseDao() {
        return dao;
    }

    final SysRoleMenuService sysRoleMenuService;

    final SysRoleDeptService sysRoleDeptService;

    private void check(SysRoleFormParam param) {
        if (StringUtils.isEmpty(param.getName()))
            throw new BusinessException(ExceptionEnum.NULL_PARAM);
        if (StringUtils.isEmpty(param.getCode()))
            throw new BusinessException(ExceptionEnum.NULL_PARAM);
    }

    @Override
    public void save(SysRoleFormParam param) {
        this.check(param);
        SysRole sameCode = this.findByCode(param.getCode());
        SysRole sameName = this.findByName(param.getName());
        SysRole query = null;
        if (param.getId() == null) {
            if (sameCode != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "角色code");
            if (sameName != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "角色名称");
            query = new SysRole();
            query.setStatus(true);
            query.setSort(this.generatorSort());
        } else {
            query = super.findByIdM(param.getId());
            if (sameCode != null && !query.getId().equals(sameCode.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "角色code");
            if (sameName != null && !query.getId().equals(sameName.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "角色名称");
        }
        BeanUtils.copyProperties(param, query);
        super.createOrUpdate(query);
        sysRoleMenuService.save(query.getId(), param.getMenuIds());
    }

    private Integer maxSort() {
        SysRole query = new SysRole();
        query.orderByDesc("sort");
        query = super.selectOne(query);
        return query == null ? 0 : query.getSort();
    }

    private Integer generatorSort() {
        return this.maxSort() + 1;
    }

    @Override
    public void status(Long id) {
        SysRole query = super.findByIdM(id);
        query.setStatus(!query.getStatus());
        super.updateM(query);
    }

    @Override
    public void delete(Long id) {
        SysRole query = super.findByIdM(id);
        super.deleteM(query.getId());
    }

    @Override
    public SysRole findByCode(String code) {
        if (StringUtils.isEmpty(code)) return null;
        SysRole query = new SysRole();
        query.setCode(code);
        return super.selectOne(query);
    }

    @Override
    public SysRole findByName(String name) {
        if (StringUtils.isEmpty(name)) return null;
        SysRole query = new SysRole();
        query.setName(name);
        return super.selectOne(query);
    }

    private Map setParams(SysRoleSearchParam param) {
        Map params = ReflectUtil.toMap(param);
        params.put("keyword", StringUtil.concatSearch(param.getKeyword()));
        return params;
    }

    @Override
    public Map listPage(SysRoleSearchParam param) {
        Page page = new Page(param.getPageNo(), param.getPageSize());
        Map params = this.setParams(param);
        params.put("start", page.getStart());
        params.put("count", page.getPageSize());
        List<SysRoleListDTO> dtos = dao.listPage(params);
        for (SysRoleListDTO dto : dtos) {
            dto.setMenuIds(sysRoleMenuService.findMenuIds(dto.getId()));
            if (dto.getDataScope().equals(SysRoleDataScopeEnum.CUSTOM.getCode())) {
                dto.setDataScopeDeptIds(sysRoleDeptService.findDeptIds(dto.getId()));
            }
        }
        Long count = dao.count(params);
        return page.setData(dtos, count);
    }
}