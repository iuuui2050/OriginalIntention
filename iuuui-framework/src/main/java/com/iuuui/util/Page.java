package com.iuuui.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Page<T> {

    private int pageNo = 1; // 当前页码

    private int pageSize = 10; // 页面大小

    private int start = 0;  //从多少跳开始获取数据

    private long count;// 总记录数

    private boolean lastPage;//是否是最后一页

    private long totalPage; //总页数

    private List<T> list = new ArrayList<>();

    public Page(int pageNo, int pageSize) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        if (this.pageNo > 1) {
            this.setStart((this.pageNo - 1) * this.pageSize);
        }
    }

    public Map<String, Object> returnMap() {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("pageNo", this.pageNo);
        resMap.put("pageSize", this.pageSize);
        resMap.put("lastPage", this.isLastPage());
        resMap.put("totalCount", this.count);
        resMap.put("totalPage", this.totalPage);
        resMap.put("list", this.list);
        return resMap;
    }

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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        if (this.start + this.pageSize >= count) {
            this.lastPage = true;
        }
        this.count = count;
        if (count % this.pageSize == 0) {
            setTotalPage(Math.floorDiv(count, this.pageSize));
        } else {
            setTotalPage(Math.floorDiv(count, this.pageSize) + 1);
        }
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public Map<String, Object> setData(List<T> list, long count) {
        this.setList(list);
        this.setCount(count);
        return this.returnMap();
    }

}
