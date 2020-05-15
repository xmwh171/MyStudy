package com.zhou.java.Test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/25 13:07
 */
public class Debug {

    public static void main(String[] args) {
        test4();
    }

    public static void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/aop_test.xml");
        IAopInterfaceTest iAopInterfaceTest = (IAopInterfaceTest) context.getBean("aopInterfaceTestImpl");
        iAopInterfaceTest.query("测试");
    }

    public static void test2(){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("da kun");
    }

    public static void test3(){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("da kun");
    }

    public static void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/test_bean.xml");
        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingProxy");
        greeting.sayHello("da kun");
        Love love = (Love)greeting;
        love.display("da kun");
    }

}
