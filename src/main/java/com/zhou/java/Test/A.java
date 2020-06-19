package com.zhou.java.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/4 18:04
 */
public class A {


    static LongAdder i = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        int num = 4;

        CountDownLatch latch = new CountDownLatch(num);
        for(int j=0;j<num;j++){
            new Thread(()->{
                for(int x=0;x<10000;x++){
                        i.increment();
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(i);
    }
}
