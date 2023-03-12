package com.iuuui.controller.system;

import com.iuuui.base.BaseController;
import com.iuuui.base.R;
import com.iuuui.common.param.system.SysRoleFormParam;
import com.iuuui.common.param.system.SysRoleSearchParam;
import com.iuuui.domain.system.SysRole;
import com.iuuui.service.system.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author iuuui
 * @time 20230312 2328
 */
@Api(tags = "角色模块")
@RestController
@RequestMapping(value = "/sys/SysRole")
public class SysRoleController extends BaseController {

    final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public R save(@RequestBody SysRoleFormParam param) {
        sysRoleService.save(param);
        return success();
    }

    @ApiOperation("修改状态")
    @PutMapping(value = "/status")
    public R status(Long id) {
        sysRoleService.status(id);
        return success();
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/delete")
    public R delete(Long id) {
        sysRoleService.delete(id);
        return success();
    }

    @ApiOperation("分页列表")
    @GetMapping(value = "/listPage")
    public R listPage(SysRoleSearchParam param) {
        Map map = sysRoleService.listPage(param);
        return success(map);
    }

}
