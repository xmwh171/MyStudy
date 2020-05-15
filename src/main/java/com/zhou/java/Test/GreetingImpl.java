package com.zhou.java.Test;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/26 9:32
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello:"+name);
    }
}
