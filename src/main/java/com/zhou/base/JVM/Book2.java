package com.zhou.base.JVM;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/2/21 15:35
 */
public class Book2 {

    public static void main(String[] args)
    {
        staticFunction();
        new Book2();
    }

    static Book2 book2 = new Book2();

    static
    {
        System.out.println("书的静态代码块");
    }

    {
        System.out.println("书的普通代码块");
    }

    Book2()
    {
        System.out.println("书的构造方法");
        System.out.println("price=" + price +",amount=" + amount);
        System.out.println(book2);
    }

    public static void staticFunction(){
        System.out.println("书的静态方法");
        System.out.println(amount);
    }

    int price = 110;
    static int amount = 112;
}
