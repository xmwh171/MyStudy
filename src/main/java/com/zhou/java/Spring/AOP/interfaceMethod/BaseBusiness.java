package com.zhou.java.Spring.AOP.interfaceMethod;

/**
 * @Description 业务类，也是目标对象
 * @Author xiaohu
 * @Date 2019/7/24 18:53
 */
public class BaseBusiness implements IBaseBusiness {

    /**
     * 切入点
     */
    @Override
    public String delete(String obj) {
        System.out.println("==========调用切入点：" + obj + "说：你敢删除我！===========\n");
        return obj + "：瞄～";
    }

    @Override
    public String add(String obj) {
        System.out.println("================这个方法不能被切。。。============== \n");
        return obj + "：瞄～ 嘿嘿！";
    }

    @Override
    public String modify(String obj) {
        System.out.println("=================这个也设置加入切吧====================\n");
        return obj + "：瞄改瞄啊！";
    }
}
