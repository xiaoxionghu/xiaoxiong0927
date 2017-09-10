package com.xiaohu.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create with IntelliJ IDEA.
 * User: xiaohu
 * Date: 2017/9/7
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivilegeInfo {
    String name() default "";
}
