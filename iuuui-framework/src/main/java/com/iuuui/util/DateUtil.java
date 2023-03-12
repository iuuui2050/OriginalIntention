package com.iuuui.util;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author iuuui
 * @since 2023/02/17 1651
 */
public class DateUtil {

    public static boolean smsValidateDate(String redisDate){
        Long differ =  new Date().getTime() - Long.parseLong(redisDate);
        if(differ > 600000) //十分钟
            return false;
        return true;
    }

    public static Date getDate() {
        String key = "date:current";
        HttpServletRequest request = ServletUtil.getRequest();
        if (request == null) return new Date();
        Object attribute = request.getAttribute(key);
        if (attribute == null)
            request.setAttribute(key, (attribute = new Date()));
        return (Date) attribute;
    }

}
