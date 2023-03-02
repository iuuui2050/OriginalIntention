package com.iuuui.util.sort.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023/02/17 0900
 */
public class SortMapperDTO {

    private Integer startNum;

    private Integer endNum;

    private Integer num;

    private Map<String, Object> params = new HashMap<>();

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void setParams(String key, Object value) {
        if (params == null)
            params = new HashMap<>();
        params.put(key, value);
    }
}
