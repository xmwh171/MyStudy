package com.zhou.java.Spring.AOP.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    /**
     * ClassLoader loader���������
     * Class<?>[] interfaces���õ�ȫ���Ľӿ�
     * InvocationHandler h���õ�InvocationHandler�ӿڵ�����ʵ�����ȴ������
     *
     * ��ί�ж��󲢷���һ��������
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //ȡ�ô������
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);   //Ҫ�󶨽ӿ�(����һ��ȱ�ݣ�cglib�ֲ�����һȱ��)
    }

    /**
     * Object proxy :ָ������Ķ���
     * Method method ��Ҫ���õķ���
     * Object[] args����������ʱ����Ҫ�Ĳ���
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
        System.out.println("���￪ʼ");
        //ִ�з���  ��Java������ƶ�̬����
        result=method.invoke(target, args);
        System.out.println("�������");
        return result;
    }
}
