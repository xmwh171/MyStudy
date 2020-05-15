package com.zhou.java.mulitthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {


    public static void main(String[] args) {
        //����ʹ�õ����̵߳��̳߳�
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            es1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "����ִ������");
                }
            });
        }
        //����ʹ�ù̶��߳������̳߳�
        ExecutorService es2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            es2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "����ִ������");
                }
            });
        }
        //����һ���������Ҫ�������̵߳��̳߳�
        ExecutorService es3 = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            es3.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "����ִ������");
                }
            });
        }
        //����ӵ�й̶��߳������Ķ�ʱ�߳�������̳߳�
        ScheduledExecutorService es4 = Executors.newScheduledThreadPool(2);
        System.out.println("ʱ�䣺" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            es4.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ʱ�䣺"+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "����ִ������");
                }
            },3, TimeUnit.SECONDS);
        }


        ExecutorService es5 = Executors.newWorkStealingPool();


     //   ExecutorService es6 = Executors.newF();
    }
}
