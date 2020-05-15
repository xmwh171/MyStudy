package com.zhou.java.mulitthread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {


    //Ԫ�ؼ���
    private LinkedList<Object> list=new LinkedList<Object>();
    //������(ͬ��),�жϼ���Ԫ������
    private AtomicInteger count=new AtomicInteger();
    //��������������,final����ָ����ֵ
    private final int minSize=0;
    private final int maxSize;
    //������ָ�����ֵ
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    //��ʼ������,���ڼ���,Ҳ��ֱ����this
    private Object lock=new Object();
    //put����:�����������Ԫ��,�������Ԫ������,����߳�����,ֱ���пռ��ټ���
    public void put(Object obj){
        synchronized (lock) {
            while(count.get()==this.maxSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();}
            }
            list.add(obj);
            //��������һ
            count.incrementAndGet();
            System.out.println("����Ԫ��:"+obj);
            //������һ���߳�,(���������:����һ��ʼ���ǿ�,��ʱtake�̻߳�һֱ�ȴ�)
            lock.notify();
        }
    }
    //take����:��Ԫ����ȡ����,�������Ϊ��,���߳�����,ֱ�����ϲ�Ϊ���ټ���
    public Object take(){
        Object result=null;
        synchronized(lock){
            while(count.get()==this.minSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();}
            }
            //�Ƴ���һ��
            result=list.removeFirst();
            //��������һ
            count.decrementAndGet();
            System.out.println("����Ԫ��:"+result);
            //������һ���߳�,(���������:����һ��ʼ��������,��ʱput�̻߳�һֱ�ȴ�)
            lock.notify();
        }
        return result;
    }
    public int getSize(){
        return this.count.get();
    }
    public static void main(String[] args) {
        //������������
        MyQueue queue=new MyQueue(5);
        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.put("4");
        queue.put("5");
        System.out.println("��ǰ��������Ϊ:"+queue.getSize());
        Thread t1=new Thread(()->{
            queue.put("6");
            queue.put("7");
        },"t1");
        Thread t2=new Thread(()->{
            Object take1 = queue.take();
            Object take2 = queue.take();
        },"t2");
        //���Լ������,�����Ӻ���ִ����һ���߳�
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
