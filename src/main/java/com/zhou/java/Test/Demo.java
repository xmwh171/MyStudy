package com.zhou.java.Test;

/**
 * @Description   interrupt 标记线程中断为1,InterruptedException 复位中断信号
 * @Author xiaohu
 * @Date 2020/10/28 16:27
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("start");
                    Thread.sleep(2000);
                    System.out.println("end");
                } catch (InterruptedException e) {
                    System.out.println("in:"+Thread.currentThread().getName());
                    System.out.println("catch_isInterrupted:"+Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        },"thread-1");
        t.start();
        System.out.println("out:"+Thread.currentThread().getName());
        Thread.sleep(1000);
        t.interrupt(); // 抛出异常
        System.out.println("t_state:"+t.getState());
        System.out.println("t_isInterrupted:"+t.isInterrupted());
        Thread.sleep(2000);
        System.out.println("t_state:"+t.getState());
        System.out.println("t_isInterrupted:"+t.isInterrupted());
    }
}
