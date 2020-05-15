package com.zhou.java.mulitthread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for(int i=0;i<10000;i++){
            tickets.add("Ʊ���:"+i);
        }
    }


    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            new Thread(()->{
                while(true){
                   String s = tickets.poll();   // ԭ���ԣ��ײ�ʵ��CAS
                   if(s == null)break;
                   else  System.out.println("������--"+s);
                }
            }).start();
        }
    }

}
