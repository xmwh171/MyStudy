package com.zhou.java.IO.nio;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程下byteBuffer读写测试
 */
public class ByteBufferThreadDemo {

    private ByteBuffer byteBuffer;

    public static void main(String[] args) {
        ByteBufferThreadDemo demo = new ByteBufferThreadDemo();
      //  demo.getPut();       线程不安全
        demo.getPutSync();    //  如果一个缓冲区要由多个线程使用，则应通过适当的同步来控制对该缓冲区的访问
    }


    public void putData(){
        byteBuffer = ByteBuffer.allocate(5);
        for(int i = 1; i < byteBuffer.capacity(); i++) {
            byteBuffer.put( (byte)i);
        }
        byteBuffer.flip();
    }

    public void getData(){
        System.out.println(Thread.currentThread().getName() +"获得的数据为："+ byteBuffer.get());
    }

    public synchronized void getDataSync(){
        System.out.println(Thread.currentThread().getName() +"获得的数据为："+ byteBuffer.get());
    }


    public void getPut(){
        putData();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<3; i++){
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    getData();
                }
            });
        }
    }


    public void getPutSync(){
        putData();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<3; i++){
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    getDataSync();
                }
            });
        }
    }

}
