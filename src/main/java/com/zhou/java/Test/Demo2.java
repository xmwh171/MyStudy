package com.zhou.java.Test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/10/28 16:44
 */
public class Demo2 {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true){
                    i++;
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
