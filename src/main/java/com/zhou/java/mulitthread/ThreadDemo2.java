package com.zhou.java.mulitthread;

/**
 * ʵ��Runnable�ӿ�
 */
public class ThreadDemo2 implements Runnable{


    @Override
    public void run() {
        System.out.println("ʵ��Runnable�ӿ�");
    }

    public static void main(String[] args) {
       Thread thread = new Thread(new ThreadDemo2());
       thread.start();
    }
}
