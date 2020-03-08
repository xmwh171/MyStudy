package com.zhou.base.mulitthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T_ArrayBlockingQueue {

    public static void main(String[] args) throws Exception{

        //必须指定队列长度
        ArrayBlockingQueue<String> abq=new ArrayBlockingQueue<String>(2);
        abq.add("a");
        //add :添加元素,如果BlockingQueue可以容纳,则返回true,否则抛异常,支持添加集合
        System.out.println(abq.offer("b"));//容量如果不够,返回false
        //offer: 如果可能的话,添加元素,即如果BlockingQueue可以容纳,则返回true,否则返回false,支持设置超时时间
        //设置超时,如果超过时间就不添加,返回false,
        abq.offer("d", 2, TimeUnit.SECONDS);// 添加的元素,时长,单位
        //put 添加元素,如果BlockQueue没有空间,则调用此方法的线程被阻断直到BlockingQueue里面有空间再继续.
        abq.put("d");//会一直等待
        //poll 取走头部元素,若不能立即取出,则可以等time参数规定的时间,取不到时返回null,支持设置超时时间
        abq.poll();
        abq.poll(2, TimeUnit.SECONDS);//两秒取不到返回null
        //take()  取走头部元素,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
        abq.take();
        //取出头部元素,但不删除
        abq.element();
        //drainTo()
        //一次性从BlockingQueue获取所有可用的数据对象（还可以指定获取数据的个数），通过该方法，可以提升获取数据效率；不需要多次分批加锁或释放锁。
        List list=new ArrayList();
        abq.drainTo(list,2);//将队列中两个元素取到list中，取走后队列中就没有取走的元素
        System.out.println(list); //[a,b]
        System.out.println(abq);  //[]
    }
}
