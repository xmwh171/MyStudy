package com.zhou.java.DesignPattern.Proxy.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 14:27
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
