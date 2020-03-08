package com.zhou.base.mulitthread;

import java.util.concurrent.*;

public class T_Future {

    public static void main(String[] args) throws Exception{
        FutureTask<Integer> ft = new FutureTask<>(()->
        {
            TimeUnit.MILLISECONDS.sleep(2000);
            return 1000;
        });

        new Thread(ft).start();
        System.out.println(ft.get()); // 阻塞
        System.out.println("等待上面结果得到后执行");

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
