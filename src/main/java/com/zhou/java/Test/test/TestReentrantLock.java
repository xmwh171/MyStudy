package com.zhou.java.Test.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xiaohu
 * @Date 2021/3/8 16:46
 */
public class TestReentrantLock {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(){
            @Override
            public void run() {
              lock.lock();
                try {
                    Thread.sleep(600000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }.start();

    }

}
