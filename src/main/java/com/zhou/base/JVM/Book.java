package com.zhou.base.JVM;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/2/21 9:52
 */
public class Book {

    public static void main(String[] args)
    {
        System.out.println("Hello ShuYi.");
        new Book();
    }

    Book()
    {
        System.out.println("书的构造方法");
        System.out.println("price=" + price +",amount=" + amount);
    }

    {
        System.out.println("书的普通代码块");
    }

    public void f(){
        System.out.println("一般方法");
    }

    int price = 110;

    static
    {
        System.out.println("书的静态代码块");
    }

    static int amount = 112;
}
