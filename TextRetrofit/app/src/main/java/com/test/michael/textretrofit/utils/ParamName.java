package com.test.michael.textretrofit.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 13:01
 * Description:用于Gson命名策略的注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamName {
    String value();
}  