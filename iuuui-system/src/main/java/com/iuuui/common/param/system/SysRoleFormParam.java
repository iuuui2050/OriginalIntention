package com.iuuui.common.param.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author iuuui
 * @time 20230312 1356
 */
@ApiModel
public class SysRoleFormParam {

    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("唯一标识")
    private String code;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("角色关联菜单")
    private List<Long> menuIds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }
}
