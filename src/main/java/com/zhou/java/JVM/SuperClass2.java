package com.zhou.java.JVM;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/2/26 11:05
 */
public class SuperClass2 {

    //静态变量value
    public static int value = 666;
    //静态块，父类初始化时会调用
    static{
        System.out.println("父类初始化！");
    }
}

//子类
class SubClass2 extends SuperClass2{
    //静态块，子类初始化时会调用
    static{
        System.out.println("子类初始化！");
    }
}

//主类、测试类
class NotInit2 {
    public static void main(String[] args){
        System.out.println(SubClass2.value);
    }

}
