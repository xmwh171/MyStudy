package com.zhou.base.mulitthread;

public class ThreadDemo3 {

    public static void main(String[] args) {

        new Thread(){
            public void run() {
                System.out.println("Thread");
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable2");
            }
        }){
            public void run() {
                System.out.println("Runnable3");
            }
        }.start();

    }



}
