package com.zhou.java.Base.Jdk8NewFeature.interfaces;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/5/15 10:52
 */
public interface TestInterface2 {

    int a = 10;

    void test();

    default String d11(){
        return "default方法11";
    }

    default String d22(){
        return "default方法22";
    }

    static String s1(){
        return "静态方法11";
    }

    static String s2(){
        return "静态方法22";
    }
}
