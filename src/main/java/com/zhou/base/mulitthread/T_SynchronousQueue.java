package com.zhou.base.mulitthread;

import java.util.concurrent.SynchronousQueue;

public class T_SynchronousQueue {

    public static void main(String[] args) {
        SynchronousQueue<String> sq=new SynchronousQueue<String>();
        // iterator() 永远返回空，因为里面没东西。
        // peek() 永远返回null
        /**
         * isEmpty()永远是true。
         * remainingCapacity() 永远是0。
         * remove()和removeAll() 永远是false。
         */
        new Thread(()->{
            try {
                //取出并且remove掉queue里的element（认为是在queue里的。。。），取不到东西他会一直等。
                System.out.println(sq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{
            try {
                //offer() 往queue里放一个element后立即返回，
                //如果碰巧这个element被另一个thread取走了，offer方法返回true，认为offer成功；否则返回false
                //true ,上面take线程一直在等,
                ////下面刚offer进去就被拿走了,返回true,如果offer线程先执行,则返回false
                System.out.println(sq.offer("b"));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{
            try {
                //往queue放进去一个element以后就一直wait直到有其他thread进来把这个element取走
                sq.put("a");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
