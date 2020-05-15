package com.zhou.java.mulitthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketSeller3 {

    static List<String> tickets = new ArrayList<>();

    static {
        for(int i=0;i<10000;i++){
            tickets.add("Ʊ���:"+i);
        }
    }


    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            new Thread(()->{
                while(true){
                    synchronized (tickets){
                        if(tickets.size()<=0) break;
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("������--"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
