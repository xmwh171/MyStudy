package com.zhou.base.Test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/25 13:01
 */
public class AopInterfaceTestImpl implements IAopInterfaceTest {

    @Override
    public String query(String name) {
        System.out.println("查询名称");
        int i = 1/0;
        return name;
    }

    @Override
    public void add(String name) {
        System.out.println("增加姓名");
    }

    @Override
    public void update(String name) {
        System.out.println("修改姓名");
    }
}
