package com.iuuui.util;


import com.iuuui.constants.ExceptionEnum;
import com.iuuui.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author iuuui
 * @since 2023/02/16 1717
 */
public class ObjectUtil {

    public static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

    public static void checkEmpty(Object... objs) {
        if (objs == null) throw new BusinessException(ExceptionEnum.NULL_PARAM);
        for (Object obj : objs) {
            if (obj == null || (obj instanceof String && StringUtil.isEmpty(obj.toString())))
                throw new BusinessException(ExceptionEnum.NULL_PARAM);
        }
    }

}
