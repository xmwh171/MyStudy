package com.zhou.java.JVM;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/2/26 11:02
 */
//常量类
public class ConstClass {
    static{
        System.out.println("常量类初始化！");
    }

    public static final String HELLOWORLD = "hello world!";
}

//主类、测试类
class NotInit {
    public static void main(String[] args){
        System.out.println(ConstClass.HELLOWORLD);
    }
}