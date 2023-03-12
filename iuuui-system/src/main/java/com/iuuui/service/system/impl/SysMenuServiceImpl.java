package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.common.constants.system.SysMenuTypeEnum;
import com.iuuui.common.dto.system.SysMenuTreeDTO;
import com.iuuui.common.param.system.SysMenuFormParam;
import com.iuuui.constants.ExceptionEnum;
import com.iuuui.domain.system.SysMenu;
import com.iuuui.exception.BusinessException;
import com.iuuui.service.system.SysMenuService;
import com.iuuui.dao.system.SysMenuDao;
import com.iuuui.util.ObjectUtil;
import com.iuuui.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iuuui
 * @since 2023-03-11 15:50
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {

    final SysMenuDao dao;

    public SysMenuServiceImpl(SysMenuDao dao) {
        this.dao = dao;
    }

    @Override
    public BaseDao<SysMenu> getBaseDao() {
        return dao;
    }

    private void check(SysMenuFormParam param) {
        ObjectUtil.checkEmpty(param.getName(), param.getParentId(), param.getType());
    }

    @Override
    public void save(SysMenuFormParam param) {
        SysMenu sameName = this.findByName(param.getName());
        SysMenu query = null;
        if (param.getId() == null) {
            if (sameName != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "菜单名称");
            query = new SysMenu();
            query.setStatus(true);
            query.setSort(this.generator(param.getParentId()));
        } else {
            query = super.findByIdM(param.getId());
            if (sameName != null && !query.getId().equals(sameName.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "菜单名称");
        }
        BeanUtils.copyProperties(param, query);
        super.createOrUpdate(query);
    }

    private Integer generator(Long parentId) {
        return this.maxSort(parentId) + 1;
    }

    private Integer maxSort(Long parentId) {
        SysMenu query = new SysMenu();
        query.setParentId(parentId);
        query = super.selectOne(query);
        return query == null ? 0 : query.getSort();
    }

    private SysMenu findByName(String name) {
        if (StringUtils.isEmpty(name)) return null;
        SysMenu query = new SysMenu();
        query.setName(name);
        return super.selectOne(query);
    }

    @Override
    public void status(Long id) {
        SysMenu query = super.getByIdM(id);
        if (query == null) throw new BusinessException(ExceptionEnum.NO_DATA);
        query.setStatus(!query.getStatus());
        super.updateM(query);
    }

    @Override
    public void delete(Long id) {
        SysMenu query = super.getByIdM(id);
        if (query == null) throw new BusinessException(ExceptionEnum.NO_DATA);
        super.deleteM(id);
    }

    @Override
    public List<SysMenuTreeDTO> findTree() {
        List<SysMenuTreeDTO> dtos = dao.list();
        List<SysMenuTreeDTO> directoryMenus = dtos.stream()
                .filter(e -> e.getType().equals(SysMenuTypeEnum.DIRECTORY.getType()))
                .sorted(Comparator.comparing(SysMenuTreeDTO::getSort)).collect(Collectors.toList());
        for (SysMenuTreeDTO dto : dtos) {
            this.recursion(dto, dtos);
        }
        return directoryMenus;
    }

    private void recursion(SysMenuTreeDTO dto, List<SysMenuTreeDTO> dtos) {
        List<SysMenuTreeDTO> childList = dtos.stream().filter(e -> e.getParentId().equals(dto.getId())).sorted(Comparator.comparing(SysMenuTreeDTO::getSort)).collect(Collectors.toList());
        for (SysMenuTreeDTO sysMenuTreeDTO : childList) {
            this.recursion(sysMenuTreeDTO, dtos);
        }
        dto.setChildList(childList);
    }
}