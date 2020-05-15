package com.zhou.java.mulitthread;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {

    public static void main(String[] args) {
        new MyExecutor().execute(()->System.out.println("MyExecutor"));
    }
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
