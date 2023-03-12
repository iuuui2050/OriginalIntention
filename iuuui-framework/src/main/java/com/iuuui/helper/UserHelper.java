package com.iuuui.helper;

/**
 * @author iuuui
 * @time 20230227 2145
 */
public class UserHelper {

    /**
     * token 过期时间
     */
    public static Long TOKEN_TIMEOUT = 60L * 3;

    /**
     * token header名称
     */
    public static String TOKEN_PARAM = "token";

    /**
     * redis 存储token前缀
     */
    public static String TOKEN_KEY_PRE = "userToken:";


    public static Long getUserId() {
        return 1L;
    }

}
