package com.zhou.java.DesignPattern.Zeren.v2;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/23 17:52
 */
public class BigManager extends Handler {
    public BigManager() {
        //部门经理处理7天以上的请假
        super(Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(ILeave leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("总经理审批：同意。");
    }
}
