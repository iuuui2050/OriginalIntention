package com.iuuui.util;


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

}
