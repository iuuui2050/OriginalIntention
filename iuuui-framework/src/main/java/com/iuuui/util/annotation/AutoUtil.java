package com.iuuui.util.annotation;

import com.iuuui.annotation.auto.AutoTime;
import com.iuuui.annotation.auto.AutoUUID;
import com.iuuui.annotation.auto.AutoUserId;
import com.iuuui.helper.UserHelper;
import com.iuuui.util.DateUtil;
import com.iuuui.util.ReflectUtil;
import com.iuuui.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author iuuui
 * @time 20230310 0004
 */
public class AutoUtil {

    public static <T> void set(T model) {
        if (model == null) return;
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            AutoUserId autoUserId = field.getAnnotation(AutoUserId.class);
            if (autoUserId != null && field.getType().equals(Long.class)) {
                Object val = ReflectUtil.get(model, field);
                if (val == null || autoUserId.force()) {
                    ReflectUtil.set(model, field, UserHelper.getUserId());
                }
            }
            AutoTime autoTime = field.getAnnotation(AutoTime.class);
            if (autoTime != null && field.getType().equals(Date.class)) {
                Object val = ReflectUtil.get(model, field);
                if (val == null || autoTime.force()) {
                    ReflectUtil.set(model, field, DateUtil.getDate());
                }
            }
            AutoUUID autoUUID = field.getAnnotation(AutoUUID.class);
            if (autoUUID != null && field.getType().equals(String.class)) {
                Object val = ReflectUtil.get(model, field);
                if (val == null || StringUtils.isEmpty(val.toString()) || autoTime.force()) {
                    ReflectUtil.set(model, field, UUIDUtil.getId());
                }
            }
        }
    }


}
