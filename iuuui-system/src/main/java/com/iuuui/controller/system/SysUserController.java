package com.iuuui.controller.system;

import com.iuuui.base.BaseController;
import com.iuuui.base.R;
import com.iuuui.common.dto.system.SysUserBasicInfoDTO;
import com.iuuui.common.param.system.SysUserBasicInfoSearchParam;
import com.iuuui.common.param.system.SysUserFormParam;
import com.iuuui.common.param.system.SysUserSearchParam;
import com.iuuui.service.system.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @time 20230312 2300
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/sys/sysUser")
public class SysUserController extends BaseController {

    final SysUserService sysUserService;


    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation("保存用户")
    @PostMapping(value = "/save")
    public R save(@RequestBody SysUserFormParam param) {
        sysUserService.save(param);
        return success();
    }

    @GetMapping("/listPage")
    public R listPage(SysUserSearchParam param) {
        Map map = sysUserService.listPage(param);
        return success(map);
    }

    @GetMapping("/listBasicInfo")
    public R listBasicInfo(SysUserBasicInfoSearchParam param) {
        List<SysUserBasicInfoDTO> dtos = sysUserService.listBasicInfo(param);
        return success(dtos);
    }


}
