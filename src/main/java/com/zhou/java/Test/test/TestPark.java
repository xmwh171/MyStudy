package com.zhou.java.Test.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/11/13 8:50
 */
public class TestPark {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() + "TestPark开始测试====");
        System.out.println("该线程线程号为:" + Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis() + "将该线程实体传入Test中");
        new Thread(new TestThread(Thread.currentThread())).start();
        System.out.println(System.currentTimeMillis() + "该线程停止====");
        LockSupport.park();
        System.out.println("park1");
        LockSupport.park();
        System.out.println("park2");
        System.out.println(System.currentTimeMillis() + "线程恢复======");
    }

}

class TestThread implements Runnable {
    private Thread thread;

    public TestThread() {

    }

    public TestThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            System.out.println(System.currentTimeMillis() + "等待开始");
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + "等待结束");
        } catch (Exception e) {
            System.out.println("等待失败");
        }
        LockSupport.unpark(thread);
        LockSupport.unpark(thread);
        System.out.println("unpark");
        System.out.println("thread：" + thread.getId() + "释放许可");
    }
}
