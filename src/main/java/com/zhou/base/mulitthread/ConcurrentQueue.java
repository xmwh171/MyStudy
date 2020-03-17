package com.zhou.base.mulitthread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedDeque<>();

        for(int i=0;i<10;i++){
            strs.offer("a"+i);     // 添加一个元素并返回trueRe
        }

        System.out.println(strs);
        System.out.println(strs.size());

        System.out.println(strs.poll());   //  移除并返问队列头部的元素
        System.out.println(strs.size());

        System.out.println(strs.peek());  // 返回队列头部的元素
        System.out.println(strs.size());

    }
}
