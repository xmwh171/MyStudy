package com.zhou.java.mulitthread;

import java.util.concurrent.*;

/**
 * @Description
 * @Author xiaohu
 * @Date 2021/3/17 13:06
 */
public class TestException {


    public static void main(String[] args) {
          t6();
    }

    public static void t1(){
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        executorService.execute(()->{
            int i=1/0;
        });
        executorService.execute(()->{
            System.out.println("当线程池抛出异常后继续新的任务");
        });
    }

    public static void t2(){
        //创建线程对象 内部会抛出异常
        Thread thread = new Thread(()->{
            int i=1/0;
        });
        //设置该对象的默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e)->{
            System.out.println("exceptionHandler"+e.getMessage());
        });
        //启动线程
        thread.start();
    }

    public static void t3(){
        ExecutorService executorService=Executors.newFixedThreadPool(1);
        Thread thread=new Thread(()->{
            int i=1/0;
        });
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e)->{
            System.out.println("exceptionHandler"+e.getMessage());
        });
        executorService.execute(thread);
    }

    public static void t4(){
        //1.实现一个自己的线程池工厂
        ThreadFactory factory = (Runnable r) -> {
            //创建一个线程
            Thread t = new Thread(r);
            //给创建的线程设置UncaughtExceptionHandler对象 里面实现异常的默认逻辑
            Thread.setDefaultUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                System.out.println("线程工厂设置的exceptionHandler" + e.getMessage());
            });
            return t;
        };

        //2.创建一个自己定义的线程池，使用自己定义的线程工厂
        ExecutorService service = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue(10),factory);

        //3.提交任务
        service.execute(()->{
            int i=1/0;
        });
    }

    // 控制台没有异常信息，因为submit有返回值，内部异常被futureTask放进了future的返回结果中，需要future接收
    public static void t5(){
        //1.实现一个自己的线程池工厂
        ThreadFactory factory = (Runnable r) -> {
            //创建一个线程
            Thread t = new Thread(r);
            //给创建的线程设置UncaughtExceptionHandler对象 里面实现异常的默认逻辑
            Thread.setDefaultUncaughtExceptionHandler((Thread thread1, Throwable e) -> {
                System.out.println("线程工厂设置的exceptionHandler" + e.getMessage());
            });
            return t;
        };

        //2.创建一个自己定义的线程池，使用自己定义的线程工厂
        ExecutorService service = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue(10),factory);

        //3.提交任务
        service.submit(()->{
            int i=1/0;
        });
    }

    public static void t6(){
        //定义线程池
        ExecutorService service = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10)) {
            //重写afterExecute方法
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t != null) { //这个是excute提交的时候
                    System.out.println("afterExecute里面获取到异常信息" + t.getMessage());
                }
                //如果r的实际类型是FutureTask 那么是submit提交的，所以可以在里面get到异常
                if (r instanceof FutureTask) {
                    try {
                        Future<?> future = (Future<?>) r;
                        future.get();
                    } catch (Exception e) {
                        System.out.println("future里面取执行异常");
                    }
                }
            }
        };
        //2.提交任务
        service.submit(() -> {
            int i = 1 / 0;
        });
    }




}
