package com.zhou.base.mulitthread;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 问题点是虽然size（）和remove()都是加锁的，但是读写没有同时加锁，size()+remove()没有保证原子性
 */
public class TicketSeller2 {

    static Vector<String> tickets = new Vector<>();

    static {
        for(int i=0;i<10000;i++){
            tickets.add("票编号:"+i);
        }
    }


    public static void main(String[] args){

        for(int i=0;i<10;i++){
            new Thread(()->{
                while(tickets.size()>0){
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("销售了--"+tickets.remove(0));
                }
            }).start();
        }
    }
}
