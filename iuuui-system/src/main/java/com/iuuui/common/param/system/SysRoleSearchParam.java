package com.iuuui.common.param.system;

import com.iuuui.base.BasePage;
import io.swagger.annotations.ApiParam;


/**
 * @author iuuui
 * @time 20230312 1439
 */
public class SysRoleSearchParam extends BasePage {

    @ApiParam("搜索名称或备注")
    private String keyword;

    private Boolean status;

    private Integer dataScope;



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getDataScope() {
        return dataScope;
    }

    public void setDataScope(Integer dataScope) {
        this.dataScope = dataScope;
    }
}
