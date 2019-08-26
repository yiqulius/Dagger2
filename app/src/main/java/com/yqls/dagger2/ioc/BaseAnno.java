package com.yqls.dagger2.ioc;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class BaseAnno {

}

/**
 * 运行时注解，可以在程序运行时动态获取注解中的值
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface  Column{

    public String name() default "fieldName";
}
