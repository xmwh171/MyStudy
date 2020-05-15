package com.zhou.java.Spring.IOC.testByInject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定需要注入的属性
 *
 * @Author xiaohu
 * @Date 2019/8/5 12:49
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
