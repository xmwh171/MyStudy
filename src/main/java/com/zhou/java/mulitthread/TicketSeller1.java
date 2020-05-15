package com.zhou.java.mulitthread;

import java.util.ArrayList;
import java.util.List;

/**
 * �����Ƕ��̶߳�дʱδ�������̲߳���ȫ
 */
public class TicketSeller1 {

    static List<String> tickets = new ArrayList<>();

    static {
        for(int i=0;i<10000;i++){
            tickets.add("Ʊ���:"+i);
        }
    }


    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            new Thread(()->{
                while(tickets.size()>0){
                    System.out.println("������--"+tickets.remove(0));
                }
            }).start();
        }
    }

}
