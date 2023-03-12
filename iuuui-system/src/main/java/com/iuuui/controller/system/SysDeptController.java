package com.iuuui.controller.system;

import com.iuuui.base.BaseController;
import com.iuuui.base.R;
import com.iuuui.common.dto.system.SysDeptTreeDTO;
import com.iuuui.common.param.system.SysDeptFormParam;
import com.iuuui.service.system.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @author iuuui
 * @time 20230312 2345
 */
@Api(tags = "部门模块")
@RestController
@RequestMapping(value = "/sys/SysDept")
public class SysDeptController extends BaseController {

    final SysDeptService sysDeptService;

    public SysDeptController(SysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }

    @ApiOperation("保存公司(最高一级公司信息)")
    @PostMapping("/saveTopLevel")
    public R saveTopLevel(String name) {
        sysDeptService.saveTopLevel(name);
        return success();
    }

    @ApiOperation("保存部门")
    @PostMapping("/save")
    public R save(@RequestBody SysDeptFormParam param) {
        sysDeptService.save(param);
        return success();
    }

    @ApiOperation("修改状态")
    @PutMapping("/status")
    public R status(Long id) {
        sysDeptService.status(id);
        return success();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public R delete(Long id) {
        sysDeptService.delete(id);
        return success();
    }

    @ApiOperation("树结构")
    @GetMapping("/findTree")
    public R findTree() {
        SysDeptTreeDTO tree = sysDeptService.findTree();
        return success(tree);
    }
}
