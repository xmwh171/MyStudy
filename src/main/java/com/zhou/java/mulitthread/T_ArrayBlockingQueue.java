package com.zhou.java.mulitthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T_ArrayBlockingQueue {

    public static void main(String[] args) throws Exception{

        //����ָ�����г���
        ArrayBlockingQueue<String> abq=new ArrayBlockingQueue<String>(2);
        abq.add("a");
        //add :���Ԫ��,���BlockingQueue��������,�򷵻�true,�������쳣,֧����Ӽ���
        System.out.println(abq.offer("b"));//�����������,����false
        //offer: ������ܵĻ�,���Ԫ��,�����BlockingQueue��������,�򷵻�true,���򷵻�false,֧�����ó�ʱʱ��
        //���ó�ʱ,�������ʱ��Ͳ����,����false,
        abq.offer("d", 2, TimeUnit.SECONDS);// ��ӵ�Ԫ��,ʱ��,��λ
        //put ���Ԫ��,���BlockQueueû�пռ�,����ô˷������̱߳����ֱ��BlockingQueue�����пռ��ټ���.
        abq.put("d");//��һֱ�ȴ�
        //poll ȡ��ͷ��Ԫ��,����������ȡ��,����Ե�time�����涨��ʱ��,ȡ����ʱ����null,֧�����ó�ʱʱ��
        abq.poll();
        abq.poll(2, TimeUnit.SECONDS);//����ȡ��������null
        //take()  ȡ��ͷ��Ԫ��,��BlockingQueueΪ��,��Ͻ���ȴ�״ֱ̬��Blocking���µĶ��󱻼���Ϊֹ
        abq.take();
        //ȡ��ͷ��Ԫ��,����ɾ��
        abq.element();
        //drainTo()
        //һ���Դ�BlockingQueue��ȡ���п��õ����ݶ��󣨻�����ָ����ȡ���ݵĸ�������ͨ���÷���������������ȡ����Ч�ʣ�����Ҫ��η����������ͷ�����
        List list=new ArrayList();
        abq.drainTo(list,2);//������������Ԫ��ȡ��list�У�ȡ�ߺ�����о�û��ȡ�ߵ�Ԫ��
        System.out.println(list); //[a,b]
        System.out.println(abq);  //[]
    }
}
