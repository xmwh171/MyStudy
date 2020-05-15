package com.zhou.java.mulitthread;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable
 */
public class ThreadDemo4 implements Callable {


    @Override
    public Object call() throws Exception {
        return 1;
    }


    public static void main(String[] args) throws Exception {

        ThreadDemo4 threadDemo4 = new ThreadDemo4();
        FutureTask ft = new FutureTask(threadDemo4);
        new Thread(ft).start();
        System.out.println(ft.get());

    }
}
