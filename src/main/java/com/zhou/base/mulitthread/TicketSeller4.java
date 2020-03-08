package com.zhou.base.mulitthread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for(int i=0;i<10000;i++){
            tickets.add("票编号:"+i);
        }
    }


    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            new Thread(()->{
                while(true){
                   String s = tickets.poll();   // 原子性，底层实现CAS
                   if(s == null)break;
                   else  System.out.println("销售了--"+s);
                }
            }).start();
        }
    }

}
