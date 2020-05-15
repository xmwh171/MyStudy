package com.zhou.java.mulitthread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedDeque<>();

        for(int i=0;i<10;i++){
            strs.offer("a"+i);     // ���һ��Ԫ�ز�����trueRe
        }

        System.out.println(strs);
        System.out.println(strs.size());

        System.out.println(strs.poll());   //  �Ƴ������ʶ���ͷ����Ԫ��
        System.out.println(strs.size());

        System.out.println(strs.peek());  // ���ض���ͷ����Ԫ��
        System.out.println(strs.size());

    }
}
