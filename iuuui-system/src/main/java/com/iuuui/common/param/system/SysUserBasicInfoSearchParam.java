package com.iuuui.common.param.system;

import com.iuuui.base.BasePage;

/**
 * @author iuuui
 * @time 20230312 2117
 */
public class SysUserBasicInfoSearchParam extends BasePage {

    private String keyword;

    private Integer status;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
