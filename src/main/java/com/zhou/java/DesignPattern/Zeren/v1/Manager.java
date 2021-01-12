package com.zhou.java.DesignPattern.Zeren.v1;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/23 17:45
 */
public class Manager implements IHandler {
    @Override
    public void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("部门经理审批：同意。");
    }
}
