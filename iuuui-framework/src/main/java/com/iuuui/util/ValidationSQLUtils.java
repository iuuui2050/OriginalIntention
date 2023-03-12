package com.iuuui.util;

import com.iuuui.constants.ExceptionEnum;
import com.iuuui.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;


public class ValidationSQLUtils {

    private final static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";


    public static Boolean illegal(String param) {
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(param).find();
    }

    public static String checkIllegal(String param) {
        if (StringUtils.isEmpty(param)) return null;
        if (illegal(param))
            throw new BusinessException(ExceptionEnum.NULL_PARAM);
        return param;
    }

}
