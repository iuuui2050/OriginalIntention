package com.iuuui.controller.system;

import com.iuuui.base.BaseController;
import com.iuuui.base.R;
import com.iuuui.common.dto.system.SysMenuTreeDTO;
import com.iuuui.common.param.system.SysMenuFormParam;
import com.iuuui.service.system.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iuuui
 * @time 20230312 2336
 */
@Api(tags = "菜单模块")
@RestController
@RequestMapping(value = "/sys/SysMenu")
public class SysMenuController extends BaseController {

    final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public R save(@RequestBody SysMenuFormParam param) {
        sysMenuService.save(param);
        return success();
    }

    @ApiOperation("修改状态")
    @PutMapping("/status")
    public R status(Long id) {
        sysMenuService.status(id);
        return success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public R delete(Long id) {
        sysMenuService.delete(id);
        return success();
    }

    @ApiOperation("树结构")
    @GetMapping("/findTree")
    public R findTree() {
        List<SysMenuTreeDTO> tree = sysMenuService.findTree();
        return success(tree);
    }

}
