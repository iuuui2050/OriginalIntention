package com.iuuui.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringFactoryUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }

    public static Object getObject(String id) {
        Object object = null;
        object = context.getBean(id);
        return object;
    }

    public static <T> T getObject(Class<T> T) {
        T bean = context.getBean(T);
        return bean;
    }

}
