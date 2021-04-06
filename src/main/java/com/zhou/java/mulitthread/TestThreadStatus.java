package com.zhou.java.mulitthread;

/**
 * @Description 测试线程状态
 * @Author xiaohu
 * @Date 2021/3/16 13:26
 */
public class TestThreadStatus {

    public static void testBlocked() throws Exception {
        class Counter {
            int counter;
            public synchronized void increase() {
                counter++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.increase();
            }
        }, "t1线程");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.increase();
            }
        }, "t2线程");
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t3线程");
        t3.start();


        Thread.sleep(100); // 确保 t2 run已经得到执行
        System.out.println(t1.getName()+t1.getState());
        System.out.println(t2.getName()+t2.getState());
        System.out.println(t3.getName()+t3.getState());

        //输出结果： t1线程TIMED_WAITING t2线程BLOCKED t3线程WAITING
    }

    public static void main(String[] args) {
        try {
            testBlocked();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
