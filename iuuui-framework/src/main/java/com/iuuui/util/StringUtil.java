package com.iuuui.util;


import org.apache.commons.lang3.StringUtils;


/**
 * @author iuuui
 * @since 2023/02/17 1617
 */
public class StringUtil extends StringUtils {

    public static String concatSearch(String str) {
        ValidationSQLUtils.checkIllegal(str);
        return str == null || "".equals(str) ? null : "%" + str + "%";
    }


}
