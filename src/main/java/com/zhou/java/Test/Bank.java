package com.zhou.java.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/10/28 16:55
 */
public class Bank {

    private Lock bankLock;
    private Condition sufficientFunds;
    public Bank() {
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }
    public void transfer() throws InterruptedException {
        bankLock.lock(); // 线程t2不抛出异常，可能发生同步阻塞，建议使用带超时的tryLock(1000,TimeUnit.MILLISECONDS)，调用interrupt时抛出异常
//           if (bankLock.tryLock()) // 线程t2获取不到锁，立即离开做其他事情
//           if (bankLock.tryLock(3000, TimeUnit.MILLISECONDS)) // 线程t2抛出异常
//           {
        try {
            while (true) {
            }
        } finally {
            bankLock.unlock();
        }
//           }
    }
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bank.transfer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    bank.transfer();
                    System.out.println("end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(2000);
        t2.interrupt();
    }
}
