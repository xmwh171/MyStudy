package com.zhou.java.Test;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/26 10:00
 */
@Component
public class LoveAdvice extends DelegatingIntroductionInterceptor implements Love {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable{
        return super.invoke(mi);
    }

    @Override
    public void display(String name) {
        System.out.println("I am your father:"+name);
    }
}
