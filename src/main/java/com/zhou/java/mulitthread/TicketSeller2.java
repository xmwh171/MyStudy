package com.zhou.java.mulitthread;

import java.util.Vector;

/**
 * ���������Ȼsize������remove()���Ǽ����ģ����Ƕ�дû��ͬʱ������size()+remove()û�б�֤ԭ����
 */
public class TicketSeller2 {

    static Vector<String> tickets = new Vector<>();

    static {
        for(int i=0;i<10000;i++){
            tickets.add("Ʊ���:"+i);
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
                    System.out.println("������--"+tickets.remove(0));
                }
            }).start();
        }
    }
}
