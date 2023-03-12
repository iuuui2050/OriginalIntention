package com.iuuui.annotation.auto;

import java.lang.annotation.*;

/**
 * @author iuuui
 * @time 20230311 0001
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoUUID {

    boolean force() default false;

}
