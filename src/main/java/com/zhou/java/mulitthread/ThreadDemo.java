package com.zhou.java.mulitthread;

/**
 * �̳�Thread�����߳�
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("running...");;
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

}
