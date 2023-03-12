package com.iuuui.service.system.impl;

import com.iuuui.base.BaseDao;
import com.iuuui.base.BaseServiceImpl;
import com.iuuui.common.dto.system.SysUserBasicInfoDTO;
import com.iuuui.common.dto.system.SysUserListDTO;
import com.iuuui.common.param.system.SysUserBasicInfoSearchParam;
import com.iuuui.common.param.system.SysUserFormParam;
import com.iuuui.common.param.system.SysUserSearchParam;
import com.iuuui.constants.ExceptionEnum;
import com.iuuui.domain.system.SysUser;
import com.iuuui.exception.BusinessException;
import com.iuuui.service.system.SysUserPasswordService;
import com.iuuui.service.system.SysUserRoleService;
import com.iuuui.service.system.SysUserService;
import com.iuuui.dao.system.SysUserDao;
import com.iuuui.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    final SysUserDao dao;

    public SysUserServiceImpl(SysUserDao dao, SysUserRoleService sysUserRoleService, SysUserPasswordService sysUserPasswordService) {
        this.dao = dao;
        this.sysUserRoleService = sysUserRoleService;
        this.sysUserPasswordService = sysUserPasswordService;
    }

    @Override
    public BaseDao<SysUser> getBaseDao() { return dao; }

    final SysUserRoleService sysUserRoleService;

    final SysUserPasswordService sysUserPasswordService;

    @Override
    public Long countByDeptId(Long deptId) {
        if (deptId == null) throw new BusinessException(ExceptionEnum.NULL_PARAM);
        SysUser query = new SysUser();
        query.setDeptId(deptId);
        return super.countM(query);
    }

    private void check(SysUserFormParam param) {
        if (StringUtil.isEmpty(param.getName())) throw new BusinessException(ExceptionEnum.NULL_PARAM, "姓名");
        if (StringUtil.isEmpty(param.getTelCode())) throw new BusinessException(ExceptionEnum.NULL_PARAM, "电话区号");
        if (StringUtil.isEmpty(param.getTel())) throw new BusinessException(ExceptionEnum.NULL_PARAM, "电话");
        if (param.getDeptId() == null) throw new BusinessException(ExceptionEnum.NULL_PARAM, "部门");
        if (param.getRoleIds().size() == 0) throw new BusinessException(ExceptionEnum.NULL_PARAM, "角色");
    }

    @Override
    public void save(SysUserFormParam param) {
        this.check(param);
        SysUser sameName = this.findByName(param.getName());
        SysUser sameTel = this.findByTel(param.getTelCode(), param.getTel());
        SysUser query = null;
        if (param.getId() == null) {
            if (sameName != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "姓名");
            if (sameTel != null) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "电话号码");
            query = new SysUser();
        } else {
            query = super.findByIdM(param.getId());
            if (sameName != null && !sameName.getId().equals(query.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "姓名");
            if (sameTel != null && !sameTel.getId().equals(query.getId())) throw new BusinessException(ExceptionEnum.ALREADY_DATA, "电话号码");
        }
        BeanUtils.copyProperties(param, query);
        super.createOrUpdate(query);

        String salt = UUIDUtil.getId();
        sysUserPasswordService.save(query.getId(), MD5Util.MD5Encode(query.getTel(), salt), salt);

        sysUserRoleService.save(query.getId(), param.getRoleIds());
    }

    private SysUser findByName(String name) {
        if (StringUtil.isEmpty(name)) return null;
        SysUser query = new SysUser();
        query.setName(name);
        return super.selectOne(query);
    }

    private SysUser findByTel(String telCode, String tel) {
        if (StringUtil.isEmpty(telCode) || StringUtil.isEmpty(tel)) return null;
        SysUser query = new SysUser();
        query.setTelCode(telCode);
        query.setTel(tel);
        return super.selectOne(query);
    }

    private Map setParams(SysUserSearchParam param) {
        Map params = ReflectUtil.toMap(param);
        params.put("keyword", StringUtil.concatSearch(param.getKeyword()));
        return params;
    }

    @Override
    public Map listPage(SysUserSearchParam param) {
        Page page = new Page(param.getPageNo(), param.getPageSize());
        Map params = this.setParams(param);
        params.put("start", page.getStart());
        params.put("count", page.getPageSize());
        List<SysUserListDTO> dtos = dao.listPage(params);
        for (SysUserListDTO dto : dtos) {
            dto.setRoleIds(sysUserRoleService.findRoleIds(dto.getId()));
        }
        Long count = dao.count(params);
        return page.setData(dtos, count);
    }

    private Map setParams(SysUserBasicInfoSearchParam param) {
        Map params = new HashMap();
        params.put("keyword", StringUtil.concatSearch(param.getKeyword()));
        params.put("status", param.getStatus());
        return params;
    }

    @Override
    public List<SysUserBasicInfoDTO> listBasicInfo(SysUserBasicInfoSearchParam param) {
        Page page = new Page(param.getPageNo(), param.getPageSize());
        Map params = this.setParams(param);
        params.put("start", page.getStart());
        params.put("count", page.getPageSize());
        List<SysUserBasicInfoDTO> dtos = dao.listBasicInfo(params);
        return dtos;
    }
}