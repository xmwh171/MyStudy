package com.zhou.base.Spring.AOP.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    /**
     * ClassLoader loader：类加载器
     * Class<?>[] interfaces：得到全部的接口
     * InvocationHandler h：得到InvocationHandler接口的子类实例，既代理对象
     *
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    /**
     * Object proxy :指被代理的对象
     * Method method ：要调用的方法
     * Object[] args：方法调用时所需要的参数
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("事物开始");
        //执行方法  ：Java反射机制动态生成
        result=method.invoke(target, args);
        System.out.println("事物结束");
        return result;
    }
}
