package com.iuuui.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author iuuui
 * @time 20230310 0037
 */
public class ReflectUtil {

    private static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

    public static final String SVUID = "serialVersionUID";

    public static final String ID = "id";

    public static Object get(Object model, Field field) {
        try {
            field.setAccessible(true);
            Object val = field.get(model);
            return val;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void set(Object model, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(model, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map toMap(Object obj) {
        return toMap(obj, false);
    }

    public static Map toMap(Object obj, boolean containSuperClass) {
        if (obj == null) return new HashMap();
        return toMap(obj, obj.getClass(), containSuperClass);
    }

    private static Map toMap(Object obj, Class clazz, boolean containSuperClass) {
        Map map = new HashMap();
        for (Field declaredField : clazz.getDeclaredFields()) {
            try {
                declaredField.setAccessible(true);
                String name = declaredField.getName();
                Object val = declaredField.get(obj);
                map.put(name, val);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (containSuperClass && clazz.getSuperclass() != null) {
            map.putAll(toMap(obj, clazz.getSuperclass(), true));
        }
        return map;
    }

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
