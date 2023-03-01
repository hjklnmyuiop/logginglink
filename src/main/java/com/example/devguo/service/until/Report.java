package com.example.devguo.service.until;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author: dev_guo
 * @Date: 2023/2/24 17:58
 */
@Target({ElementType.METHOD})
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
