package com.zhou.base.mulitthread;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class T_PriorityBlockingQueue {

    public static void main(String[] args) throws Exception{
        //队列里元素必须实现Comparable接口,用来决定优先级
        PriorityBlockingQueue<String> pbq=new PriorityBlockingQueue<String>();
        pbq.add("b");
        pbq.add("g");
        pbq.add("a");
        pbq.add("c");
        //获取的时候会根据优先级取元素,插入的时候不会排序,节省性能
        //System.out.println(pbq.take());//a,获取时会排序,按优先级获取
        System.out.println(pbq.toString());//如果前面没有取值,直接syso也不会排序
        Iterator<String> iterator = pbq.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
