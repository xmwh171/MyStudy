package com.zhou.java.DesignPattern.Zeren.v1;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/23 17:46
 */
public class BigManager implements IHandler {
    @Override
    public void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("总经理审批：同意。");
    }
}
