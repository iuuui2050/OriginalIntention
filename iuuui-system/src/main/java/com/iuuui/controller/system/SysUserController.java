package com.iuuui.controller.system;

import com.iuuui.base.BaseController;
import com.iuuui.domain.system.SysUser;
import com.iuuui.service.system.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author iuuui
 * @time 20230302 2237
 */
@RestController
@RequestMapping(value = "/SysUser")
public class SysUserController extends BaseController {

    final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping(value = "/list", name = "列表", method = RequestMethod.GET)
    public Object list() {
        List<SysUser> list = sysUserService.selectM(new SysUser());
        return list;
    }

}
