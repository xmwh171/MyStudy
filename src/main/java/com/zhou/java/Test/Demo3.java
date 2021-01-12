package com.zhou.java.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/10/28 17:24
 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 未标记中断状态，查看标记状态
                System.out.println("before interrupt:" + Thread.currentThread().isInterrupted());
                // 该方法不响应中断状态，继续执行代码
                lock.lock();
                // 已标记中断状态，查看标记状态
                System.out.println("after interrupt:" + Thread.currentThread().isInterrupted());
                // 返回中断状态，并清除中断状态
                System.out.println("doing interrupted:" + Thread.interrupted());
                // 返回中断状态，并清除中断状态
                System.out.println("doing interrupted2:" + Thread.interrupted());

                // 已标记中断状态，查看标记状态
                System.out.println("after interrupted:" + Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Catch Exception:" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
    }
}
