package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.common.constants.system.SysDeptConstants;
import com.iuuui.common.dto.system.SysDeptTreeDTO;
import com.iuuui.common.param.system.SysDeptFormParam;
import com.iuuui.constants.ExceptionEnum;
import com.iuuui.domain.system.SysDept;
import com.iuuui.exception.BusinessException;
import com.iuuui.service.system.SysDeptService;
import com.iuuui.dao.system.SysDeptDao;
import com.iuuui.service.system.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDept> implements SysDeptService {

    final SysDeptDao dao;

    public SysDeptServiceImpl(SysDeptDao dao, SysUserService sysUserService) {
        this.dao = dao;
        this.sysUserService = sysUserService;
    }

    @Override
    public BaseDao<SysDept> getBaseDao() {
        return dao;
    }

    final SysUserService sysUserService;

    @Override
    public void saveTopLevel(String name) {
        if (StringUtils.isEmpty(name)) throw new BusinessException(ExceptionEnum.NULL_PARAM);
        List<SysDept> sysDepts = this.findByParentId(SysDeptConstants.TOP_LEVEL_PARENT_ID);
        SysDept query = null;
        if (sysDepts.size() > 0) {
            query = sysDepts.get(0);
        } else {
            query = new SysDept();
            query.setParentId(SysDeptConstants.TOP_LEVEL_PARENT_ID);
        }
        query.setName(name);
        super.createOrUpdate(query);
    }

    private void check(SysDeptFormParam param) {
        if (StringUtils.isEmpty(param.getName()))
            throw new BusinessException(ExceptionEnum.NULL_PARAM);
        if (param.getParentId() == null && this.findByParentId(SysDeptConstants.TOP_LEVEL_PARENT_ID).size() > 0)
            throw new BusinessException(ExceptionEnum.NULL_PARAM);
    }

    @Override
    public void save(SysDeptFormParam param) {
        this.check(param);
        SysDept sameCode = this.findByCode(param.getCode());
        SysDept sameName = this.findByName(param.getName());
        SysDept query = null;
        if (param.getId() == null) {
            if (sameCode != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "部门code");
            if (sameName != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "部门名称");
            query = new SysDept();
        } else {
            query = super.getByIdM(param.getId());
            if (query == null) throw new BusinessException(ExceptionEnum.NO_DATA);
            if (sameCode != null && !sameCode.getId().equals(query.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "部门code");
            if (sameName != null && !sameName.getId().equals(query.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "部门名称");
        }
        BeanUtils.copyProperties(param, query);
        super.createOrUpdate(query);
    }

    @Override
    public List<SysDept> findByParentId(Long parentId) {
        if (parentId == null) throw new BusinessException(ExceptionEnum.NULL_PARAM);
        SysDept query = new SysDept();
        query.setParentId(parentId);
        return super.selectM(query);
    }

    @Override
    public Long findCountByParentId(Long parentId) {
        if (parentId == null) throw new BusinessException(ExceptionEnum.NULL_PARAM);
        SysDept query = new SysDept();
        query.setParentId(parentId);
        return super.countM(query);
    }

    @Override
    public SysDept findByName(String name) {
        if (StringUtils.isEmpty(name))
            return null;
        SysDept query = new SysDept();
        query.setName(name);
        return super.selectOne(query);
    }

    @Override
    public SysDept findByCode(String code) {
        if (StringUtils.isEmpty(code))
            return null;
        SysDept query = new SysDept();
        query.setCode(code);
        return super.selectOne(query);
    }

    @Override
    public void status(Long id) {
        SysDept query = super.getByIdM(id);
        if (query == null) throw new BusinessException(ExceptionEnum.NO_DATA);
        query.setStatus(!query.getStatus());
        super.updateM(query);
    }

    @Override
    public void delete(Long id) {
        SysDept query = super.getByIdM(id);
        if (query == null) throw new BusinessException(ExceptionEnum.NO_DATA);
        if (this.findCountByParentId(id) > 0) throw new BusinessException("部门存在子级部门无法删除");
        Long count = sysUserService.countByDeptId(id);
        if (count > 0) throw new BusinessException("部门下存在用户关联无法删除");
        super.deleteM(query.getId());
    }

    @Override
    public SysDeptTreeDTO findTree() {
        List<SysDeptTreeDTO> dtos = dao.list();
        SysDeptTreeDTO dto = dtos.stream().filter(e -> e.getParentId().equals(SysDeptConstants.TOP_LEVEL_PARENT_ID)).collect(Collectors.toList()).get(0);
        this.recursion(dto, dtos);
        return dto;
    }

    private void recursion(SysDeptTreeDTO startDTO, List<SysDeptTreeDTO> dtos) {
        List<SysDeptTreeDTO> childList = dtos.stream()
                .filter(e -> e.getParentId().equals(startDTO.getId()))
                .sorted(Comparator.comparing(SysDeptTreeDTO::getCreateTime))
                .collect(Collectors.toList());
        for (SysDeptTreeDTO dto : childList)
            this.recursion(dto, dtos);
        startDTO.setChildList(childList);
    }
}