package com.zhou.java.DesignPattern.Zeren.v1;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/23 17:47
 */
public class Test {

    public static void main(String[] args) {
        //请假条来一张
        ILeave leave = new Leave("小花",5,"身体不适");

        //小组长第一个审批
        IHandler groupLeader = new GroupLeader();
        groupLeader.handleLeave(leave);

        if(leave.getNum() >= 3){
            IHandler manager = new Manager();
            manager.handleLeave(leave);
        }
        if(leave.getNum() >= 7){
            IHandler bigManager = new BigManager();
            bigManager.handleLeave(leave);
        }
    }
}
