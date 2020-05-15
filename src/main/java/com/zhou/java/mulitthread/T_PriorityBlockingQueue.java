package com.zhou.java.mulitthread;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class T_PriorityBlockingQueue {

    public static void main(String[] args) throws Exception{
        //������Ԫ�ر���ʵ��Comparable�ӿ�,�����������ȼ�
        PriorityBlockingQueue<String> pbq=new PriorityBlockingQueue<String>();
        pbq.add("b");
        pbq.add("g");
        pbq.add("a");
        pbq.add("c");
        //��ȡ��ʱ���������ȼ�ȡԪ��,�����ʱ�򲻻�����,��ʡ����
        //System.out.println(pbq.take());//a,��ȡʱ������,�����ȼ���ȡ
        System.out.println(pbq.toString());//���ǰ��û��ȡֵ,ֱ��sysoҲ��������
        Iterator<String> iterator = pbq.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
