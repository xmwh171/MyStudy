package com.zhou.java.Base.Jdk8NewFeature.interfaces;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/5/15 10:19
 */
public interface TestInterface {

    int a = 10;

    void test();

    default String d1(){
        return "default方法1";
    }

    default String d2(){
        return "default方法2";
    }

    static String s1(){
        return "静态方法1";
    }

    static String s2(){
        return "静态方法2";
    }


    default String run(){
        return "123";
    }
}
