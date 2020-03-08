package com.zhou.base.mulitthread;

/**
 * 实现Runnable接口
 */
public class ThreadDemo2 implements Runnable{


    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }

    public static void main(String[] args) {
       Thread thread = new Thread(new ThreadDemo2());
       thread.start();
    }
}
