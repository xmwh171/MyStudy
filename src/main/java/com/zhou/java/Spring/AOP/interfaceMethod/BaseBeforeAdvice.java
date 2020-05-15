package com.zhou.java.Spring.AOP.interfaceMethod;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description 前置通知
 * @Author xiaohu
 * @Date 2019/7/24 18:55
 */
public class BaseBeforeAdvice implements MethodBeforeAdvice {

    /**
     * method : 切入的方法 <br>
     * args ：切入方法的参数 <br>
     * target ：目标对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===========进入beforeAdvice()============ \n");

        System.out.print("准备在" + target + "对象上用");
        System.out.print(method + "方法进行对 '");
        System.out.print(args[0] + "'进行删除！\n\n");

        System.out.println("要进入切入点方法了 \n");
    }
}
