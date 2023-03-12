package com.iuuui.service.system;

import com.iuuui.base.BaseService;
import com.iuuui.domain.system.SysUserPassword;

/**
 * @author iuuui
 * @since 2023-03-05 12:16
 */
public interface SysUserPasswordService extends BaseService<SysUserPassword> {

    void save(Long userId, String password, String salt);

    SysUserPassword findByUserId(Long userId);

}