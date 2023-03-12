package com.iuuui.annotation.auto;

import java.lang.annotation.*;

/**
 * @author iuuui
 * @time 20230308 2229
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoUserId {

    /**
     * When the field is not empty, force write
     */
    boolean force() default false;

}
