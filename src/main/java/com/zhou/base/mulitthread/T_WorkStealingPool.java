package com.zhou.base.mulitthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T_WorkStealingPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();



    }

}
