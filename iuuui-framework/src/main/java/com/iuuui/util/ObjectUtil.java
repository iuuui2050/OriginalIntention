package com.iuuui.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author iuuui
 * @since 2023/02/16 1717
 */
public class ObjectUtil {

    public static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

    public static final String SVUID = "serialVersionUID";

    public static final String ID = "id";

    public static Object getId(Object model) {
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(ID)) {
                Object val = null;
                try {
                    val = field.get(model);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return val;
            }
        }
        return null;
    }

    public static List<String> suffixNullField(Object obj) {
        List<String> list = new ArrayList<>();
        if (obj == null) return list;
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            if (!SVUID.equals(key)) {
                field.setAccessible(true);
                list.add(key.concat("Null"));
            }
        }

        Method method = null;
        try {
            method = clazz.getMethod("setParams", String.class, Object.class);
            method.setAccessible(true);
            for (String fieldNull : list) {
                try {
                    method.invoke(obj, fieldNull, true);
                } catch (IllegalAccessException e) {
                    logger.error("set setParams() method 异常 fieldNull: " + fieldNull, e);
                } catch (InvocationTargetException e) {
                    logger.error("set setParams() method 异常 fieldNull: " + fieldNull, e);
                }
            }
        } catch (NoSuchMethodException e) {
            logger.error("get setParams() method 异常", e);
        }

        return list;
    }


}
