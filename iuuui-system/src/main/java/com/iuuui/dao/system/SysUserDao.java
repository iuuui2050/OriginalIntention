package com.iuuui.dao.system;

import com.iuuui.base.BaseDao;
import com.iuuui.common.dto.system.SysUserBasicInfoDTO;
import com.iuuui.common.dto.system.SysUserListDTO;
import com.iuuui.domain.system.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysUserDao extends BaseDao<SysUser> {

    List<SysUserListDTO> listPage(Map params);

    Long count(Map params);

    List<SysUserBasicInfoDTO> listBasicInfo(Map params);
}