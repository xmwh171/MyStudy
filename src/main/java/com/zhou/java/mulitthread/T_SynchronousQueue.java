package com.zhou.java.mulitthread;

import java.util.concurrent.SynchronousQueue;

public class T_SynchronousQueue {

    public static void main(String[] args) {
        SynchronousQueue<String> sq=new SynchronousQueue<String>();
        // iterator() ��Զ���ؿգ���Ϊ����û������
        // peek() ��Զ����null
        /**
         * isEmpty()��Զ��true��
         * remainingCapacity() ��Զ��0��
         * remove()��removeAll() ��Զ��false��
         */
        new Thread(()->{
            try {
                //ȡ������remove��queue���element����Ϊ����queue��ġ���������ȡ������������һֱ�ȡ�
                System.out.println(sq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{
            try {
                //offer() ��queue���һ��element���������أ�
                //����������element����һ��threadȡ���ˣ�offer��������true����Ϊoffer�ɹ������򷵻�false
                //true ,����take�߳�һֱ�ڵ�,
                ////�����offer��ȥ�ͱ�������,����true,���offer�߳���ִ��,�򷵻�false
                System.out.println(sq.offer("b"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{
            try {
                //��queue�Ž�ȥһ��element�Ժ��һֱwaitֱ��������thread���������elementȡ��
                sq.put("a");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
