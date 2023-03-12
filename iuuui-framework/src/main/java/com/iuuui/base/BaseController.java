package com.iuuui.base;




/**
 * @author iuuui
 * @since 2023/02/16 1733
 */
public class BaseController {

    public static R success() {
        return R.success();
    }

    public static R success(String msg, Object data) {
        return R.success(msg, data);
    }

    public static R success(Object data) {
        return R.success(data);
    }

    public static R successMap(Object key, Object value) {
        return R.success(key, value);
    }

    public static R error(String msg) {
        return R.error(msg);
    }


}
