package com.iuuui.base;


import java.util.HashMap;

public class R {

    private Integer code;

    private String msg;

    private Object data;

    public static R success() {
        return success(null);
    }

    public static R success(String msg, Object data) {
        return new R(200, msg, data);
    }

    public static R success(Object data) {
        return success("ok", data);
    }

    public static R error(String msg) {
        return new R(500, msg, null);
    }

    public static R success(Object key, Object value) {
        HashMap map = new HashMap() {{
            put(key, value);
        }};
        return success(map);
    }

    private R() {
    }

    private R(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
