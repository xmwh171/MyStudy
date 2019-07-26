package com.zhou.base.Test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/25 13:04
 */
public class LogHandler {

    public void handlePrepare(){
        System.out.println("执行前通知");
    }

    public void handleAfter(){
        System.out.println("执行后通知");
    }

    public void handleAround(){
        System.out.println("执行环绕通知");
    }

    public void handleError(){
        System.out.println("执行错误通知");
    }

    public void handleAfterReturn(){
        System.out.println("执行返回通知");
    }

}
