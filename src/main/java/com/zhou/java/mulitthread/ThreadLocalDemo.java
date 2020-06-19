package com.zhou.java.mulitthread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/5/22 15:23
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        new ThreadLocalDemo().test();
    }

    public void test() throws InterruptedException {
        threadLocal.set("123");
        String v = threadLocal.get();
        System.out.println("Thread-0执行前，"+Thread.currentThread().getName()+"取到的值："+v);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String v = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+"线程取到的值："+v);
                threadLocal.set("456");
                v = threadLocal.get();
                System.out.println("设置后"+Thread.currentThread().getName()+"线程取到的值："+v);
                System.out.println(Thread.currentThread().getName()+"运行结束");
            }
        }).start();

        Thread.sleep(3000);
        v = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+"线程取到的值："+v);
    }

}
