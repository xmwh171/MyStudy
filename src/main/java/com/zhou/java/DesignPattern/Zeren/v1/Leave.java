package com.zhou.java.DesignPattern.Zeren.v1;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/23 17:45
 */
public class Leave implements ILeave{
    private String name;//姓名
    private int num;//请假天数
    private String content;//请假内容

    public Leave(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}
