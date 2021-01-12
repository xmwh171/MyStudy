package com.zhou.java.Spring.AOP.jdkProxy.principle;

import com.zhou.java.Spring.AOP.jdkProxy.BookFacade;
import com.zhou.java.Spring.AOP.jdkProxy.BookFacadeImpl;
import com.zhou.java.Spring.AOP.jdkProxy.BookFacadeProxy;

import java.lang.reflect.Method;

/**
 * @Description  代理类
 * @Author xiaohu
 * @Date 2020/6/19 15:30
 */
public class TempProxy implements XhInvocationHandler {

    private Object target;

    //获取被代理人的个人资料
    public Object getInstance(Object target) throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class是:"+clazz);
        return XhProxy.newProxyInstance(new XhClassLoader(), clazz.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理类的invoke方法");
        System.out.println("代理对象："+proxy);
        System.out.println("------------");
        System.out.println("执行前操作...");
        method.invoke(this.target, args);
        System.out.println("执行后操作...");
        System.out.println("------------");
        return null;
    }

    public static void main(String[] args) {
        try {
            TempProxy proxy = new TempProxy();
            BookFacade bookProxy = (BookFacade) proxy.getInstance(new BookFacadeImpl());
            System.out.println("此处的bookProxy对象是："+bookProxy);
            bookProxy.addBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
