package com.zhou.base.mulitthread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentMap {

    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();           // 高并发
//        Map<String,String> map = new ConcurrentSkipListMap<>();         // 高并发并且排序
//        Map<String,String> map2 = new HashMap<>();

        //  Map<String,String> map = new ·1();
      //  Map<String,String> map = Collections.synchronizedMap(new HashMap<>());

        Random r = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<10000;j++) map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                latch.countDown();
            });
        }
        Arrays.asList(threads).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);


    }



}
