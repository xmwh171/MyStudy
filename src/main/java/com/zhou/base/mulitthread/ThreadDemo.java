package com.zhou.base.mulitthread;

/**
 * ¼Ì³ÐThread¿ªÆôÏß³Ì
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
