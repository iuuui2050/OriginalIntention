package com.iuuui.util;


import com.iuuui.constants.ExceptionEnum;
import com.iuuui.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;


/**
 * @author iuuui
 * @since 2023/02/17 1617
 */
public class StringUtil extends StringUtils {

    public static void checkEmpty(Object... objs) {
        if (objs == null) throw new BusinessException(ExceptionEnum.PARAMETER_EMPTY_EXCEPTION);
        for (Object obj : objs) {
            if (obj == null) throw new BusinessException(ExceptionEnum.PARAMETER_EMPTY_EXCEPTION);
            if (obj instanceof String && isEmpty(obj.toString()))
                throw new BusinessException(ExceptionEnum.PARAMETER_EMPTY_EXCEPTION);
        }
    }

    public static String concatSearch(String str) {
        ValidationSQLUtils.checkIllegal(str);
        return str == null || "".equals(str) ? null : "%" + str + "%";
    }


}
