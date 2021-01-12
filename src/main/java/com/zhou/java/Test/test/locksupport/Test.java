package com.zhou.java.Test.test.locksupport;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/7 11:26
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        testLockSupport();

    }

    public static void testLockSupport() throws InterruptedException {
        Thread thread = new Thread(new ThreadPark(),"park");
        thread.start();//阻塞当前线程
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("是否中断1:"+thread.isInterrupted()+thread.getState());
        Thread thread2 = new Thread(new ThreadUnPark(thread),"unPark");
        thread2.start();//唤醒被阻塞的线程
        System.out.println("是否中断2:"+thread.isInterrupted());
        Thread.sleep(6000);
    }

    static class ThreadPark implements Runnable{
        @Override
        public void run() {
            System.out.println("ThreadPark开始");
            System.out.println("当前阻塞的线程："+Thread.currentThread().getName());
            LockSupport.park(Thread.currentThread());  //阻塞当前线程
            System.out.println("ThreadPark结束");
        }
    }

    static class ThreadUnPark implements Runnable{
        private Thread thread;

        public ThreadUnPark(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("ThreadUnPark开始");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+Thread.currentThread().getName());
            System.out.println("将被唤醒的线程："+thread.getName());
            LockSupport.unpark(thread);//唤醒被阻塞的线程
            System.out.println("ThreadUnPark结束");
        }
    }

}
