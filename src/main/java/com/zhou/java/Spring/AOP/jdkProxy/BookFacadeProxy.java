package com.zhou.java.Spring.AOP.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理原理：
 *   1.拿到被代理对象的引用，然后获取它的接口
 *   2.JDK代理重新生成一个类，同时实现我们给的代理对象所实现的接口
 *   3.把被代理对象的引用也拿到了
 *   4.重新动态生成一个class字节码
 *   5.然后编译
 */
public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法前操作--------");
        Object result = method.invoke(target,args);
        System.out.println(result);
        System.out.println("调用方法后操作--------");
        return result;
    }

}
