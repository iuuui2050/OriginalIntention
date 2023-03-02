package com.iuuui.util.sort.common;


/**
 * @author iuuui
 * @since 2023/02/17 0900
 */
public class SortDTO {

    private Object id;

    private Integer oldSort;

    private Integer newSort;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getOldSort() {
        return oldSort;
    }

    public void setOldSort(Integer oldSort) {
        this.oldSort = oldSort;
    }

    public Integer getNewSort() {
        return newSort;
    }

    public void setNewSort(Integer newSort) {
        this.newSort = newSort;
    }
}
