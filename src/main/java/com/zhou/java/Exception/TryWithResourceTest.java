package com.zhou.java.Exception;

import java.io.IOException;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/6/25 10:22
 */
public class TryWithResourceTest {

    /**
     * catch 块中，看不到 try-with-recourse 声明中的变量
     * try-with-recourse 中，try 块中抛出的异常，在 e.getMessage() 可以获得，而调用 close() 方法抛出的异常在e.getSuppressed() 获得
     * try-with-recourse 中定义多个变量时，由反编译可知，关闭的顺序是从后往前
     */
    public static void startTest() {
        try (MyAutoCloseA a = new MyAutoCloseA();
             MyAutoCloseB b = new MyAutoCloseB()) {
            a.test();
            b.test();
        } catch (Exception e) {
            System.out.println("Main: exception");
            System.out.println(e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (int i = 0; i < suppressed.length; i++) {
                System.out.println(suppressed[i].getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        startTest();
    }

}

class MyAutoCloseA implements AutoCloseable {

    public void test() throws IOException {
        System.out.println("MyAutoCloaseA: test()");
        throw new IOException("MyAutoCloaseA: test() IOException");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseA: on close()");
        throw new ClassNotFoundException("MyAutoCloaseA: close() ClassNotFoundException");
    }
}

class MyAutoCloseB implements AutoCloseable {

    public void test() throws IOException {
        System.out.println("MyAutoCloaseB: test()");
        throw new IOException("MyAutoCloaseB: test() IOException");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseB: on close()");
        throw new ClassNotFoundException("MyAutoCloaseB: close() ClassNotFoundException");
    }
}