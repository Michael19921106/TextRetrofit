package com.test.michael.textretrofit.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-03-02
 * Time: 12:58
 * Description:自定义Gson的命名策略
 */
public class GsonUtils {
    public static Gson newInstance(){
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingStrategy(new AnnotationName());
        return builder.create();
    }
    private static class AnnotationName implements FieldNamingStrategy{

        @Override
        public String translateName(Field f) {
            ParamName annotation = f.getAnnotation(ParamName.class);
            return annotation !=null ? annotation.value() : FieldNamingPolicy.IDENTITY
                    .translateName(f);
        }
    }
}  