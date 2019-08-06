package com.zhou.base.Spring.IOC.testByInject;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/5 13:21
 */
@Component
public class TestNoInjectClass {

    public void test(){
        System.out.println("未添加属性注解");
    }
}
