package com.zhou.java.DesignPattern.Zeren.v2;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/23 17:51
 */
public class GroupLeader  extends Handler {

    public GroupLeader() {
        //小组长处理1-3天的请假
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("小组长审批：同意。");
    }
}
