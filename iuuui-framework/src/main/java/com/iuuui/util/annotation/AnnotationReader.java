package com.iuuui.util.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author iuuui
 * @time 20230310 0013
 */
public class AnnotationReader {

    public static <T> T getAnnotation(Annotation[] annotations, Class<?> annotationClazz, String annoField, Class<T> type){
        try {
            String value = null;
            for (Annotation clazzAnnotation : annotations) {
                if (clazzAnnotation.annotationType().equals(annotationClazz)){
                    Method m = clazzAnnotation.getClass().getDeclaredMethod(annoField);
                    Object obj = m.invoke(clazzAnnotation);
                    if (obj == null) return null;
                    return (T) value;
                }
            }
            return (T) value;
        }catch (Exception e){
            throw new RuntimeException("get annotation is fail...",e);
        }
    }

    public static <T> T getAnnotation(Annotation annotation, String annoField, Class<T> T){
        try {
            Method m = annotation.getClass().getDeclaredMethod(annoField);
            Object obj = m.invoke(annotation);
            if (obj == null) return null;
            return (T) obj;
        }catch (Exception e){
            throw new RuntimeException("get annotation is fail...",e);
        }
    }


}
