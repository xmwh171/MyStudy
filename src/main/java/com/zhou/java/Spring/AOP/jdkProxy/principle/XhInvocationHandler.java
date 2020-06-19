package com.zhou.java.Spring.AOP.jdkProxy.principle;

import java.lang.reflect.Method;

/**
 * @Description  仿写InvocationHandler
 * @Author xiaohu
 * @Date 2020/6/19 15:28
 */
public interface XhInvocationHandler {


    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
