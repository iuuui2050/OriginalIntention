package com.iuuui.base;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iuuui
 * @since 2023/02/16 1732
 */
public class BaseModel implements Serializable {

    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        initParams();
        return params;
    }

    public void orderByAsc(String orderBy) {
        this.setParams(new HashMap(){{
            put("orderBy", orderBy);
            put("by", "asc");
        }});
    }

    public void orderByDesc(String orderBy) {
        this.setParams(new HashMap(){{
            put("orderBy", orderBy);
            put("by", "desc");
        }});
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void setParams(String key, Object value) {
        initParams();
        params.put(key, value);
    }

    public Object getParams(String key) {
        initParams();
        return params.get(key);
    }

    private void initParams() {
        if (params == null) params = new HashMap<String, Object>();
    }

}
