package com.iuuui.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletUtil {

    public static HttpServletRequest getRequest(){
        HttpServletRequest request = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null)
            request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request;
    }

    public static String getRequestURI(){
        HttpServletRequest httpServletRequest = getRequest();
        if (httpServletRequest != null)
            return ServletUtil.getRequest().getRequestURI();
        return null;
    }

    public static String getHeader(String key){
        HttpServletRequest request = getRequest();
        if (request == null) return null;
        return request.getHeader(key);
    }

    public static HttpServletResponse getResponse(){
        HttpServletResponse response = null;
        RequestAttributes responseAttributes = RequestContextHolder.getRequestAttributes();
        if (responseAttributes != null)
            response = ((ServletRequestAttributes) responseAttributes).getResponse();
        return response;
    }

    public static String getApplicationContext(){
        String contextPath = ServletUtil.getRequest().getServletContext().getContextPath();
        return contextPath.substring(1);
    }

}
