package com.iuuui.base;


/**
 * @author iuuui
 * @since 2023/02/17 0900
 */
public class BasePage {

    private int pageNo = 1;

    private int pageSize = 10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
