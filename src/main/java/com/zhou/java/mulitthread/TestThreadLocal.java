package com.zhou.java.mulitthread;

/**
 * @Description
 * 虽然ThreadLocal让访问某个变量的线程都拥有自己的局部变量，但是如果这个局部变量都指向同一个对象时，这个时候ThreadLocal就失效了
 * @Author xiaohu
 * @Date 2020/5/22 13:52
 */
public class TestThreadLocal {
    private static A a = new A();
    private static final ThreadLocal<A> threadLocal = new ThreadLocal<A>(){
        @Override
        protected A initialValue(){
            return a;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for(int i=0;i<5;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.get().setNumber(threadLocal.get().getNumber()+5);
                    System.out.println(Thread.currentThread().getName()+"："+threadLocal.get().getNumber());
                }
            },"Thread-"+i);
        }

        for(Thread thread : threads){
            thread.start();
        }
    }

}


class A{
    private int number = 0;

    public int getNumber() {
        System.out.println(Thread.currentThread().getName()+"获取值为"+number);
        return number;
    }

    public void setNumber(int number) {
        System.out.println(Thread.currentThread().getName()+"设置值为"+number);
        this.number = number;
    }
}


