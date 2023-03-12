package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.common.dto.system.SysUserBasicInfoDTO;
import com.iuuui.common.param.system.SysUserBasicInfoSearchParam;
import com.iuuui.common.param.system.SysUserFormParam;
import com.iuuui.common.param.system.SysUserSearchParam;
import com.iuuui.domain.system.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysUserService extends BaseService<SysUser> {

    Long countByDeptId(Long deptId);

    void save(SysUserFormParam param);

    Map listPage(SysUserSearchParam param);

    List<SysUserBasicInfoDTO> listBasicInfo(SysUserBasicInfoSearchParam param);

}