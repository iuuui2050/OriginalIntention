package com.iuuui.util;

import java.util.UUID;


public class UUIDUtil {

    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
