package com.zhou.java.Spring.AOP.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BookFacadeCglib implements MethodInterceptor {

    private Object target;

    /**
     * �����������
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // �ص�����
        enhancer.setCallback(this);
        // �����������
        return enhancer.create();
    }

    // �ص�����
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("���￪ʼ");
        methodProxy.invokeSuper(o, objects);
        System.out.println("�������");
        return null;
    }
}
