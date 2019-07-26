package com.zhou.base.Test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/26 9:44
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }

}
