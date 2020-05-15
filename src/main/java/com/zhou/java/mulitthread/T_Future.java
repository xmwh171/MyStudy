package com.zhou.java.mulitthread;

import java.util.concurrent.*;

public class T_Future {

    public static void main(String[] args) throws Exception{
        FutureTask<Integer> ft = new FutureTask<>(()->
        {
            TimeUnit.MILLISECONDS.sleep(2000);
            return 1000;
        });

        new Thread(ft).start();
        System.out.println(ft.get()); // ����
        System.out.println("�ȴ��������õ���ִ��");

        // ============================
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> f = executorService.submit(()->{
            TimeUnit.MILLISECONDS.sleep(2000);
            return 1;
        });

        System.out.println(f.get());
        System.out.println(f.isDone());


    }
}
