package com.zhou.java.mulitthread;

/**
 * @Description
 * interrupt();  在当前线程中打了一个停止标志
 * interrupted(): 当前线程是否已经中断；线程的中断状态由该方法清除
 * isInterrupted(): 线程是否已经中断；并未清除状态
 * @Author xiaohu
 * @Date 2020/5/22 9:33
 */
public class MyThread  extends Thread {
    @Override
    public void run() {
        while (true){
            if(this.isInterrupted()){
                System.out.println("线程被停止了！");
                return;
            }
            System.out.println("Time: " + System.currentTimeMillis());
        }
    }

}

class Run {
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
