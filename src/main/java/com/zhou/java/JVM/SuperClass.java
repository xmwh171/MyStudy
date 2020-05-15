package com.zhou.java.JVM;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/2/26 10:57
 */
public class SuperClass {

    //静态变量value
    public static int value = 666;
    //静态块，父类初始化时会调用
    static{
        System.out.println("父类初始化！");
    }
}

class NotInit3 {
    public static void main(String[] args) {
        SuperClass[] test = new SuperClass[10];
    }
}