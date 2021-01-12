package com.zhou.java.DesignPattern.Proxy.dynamicproxy;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 15:35
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
