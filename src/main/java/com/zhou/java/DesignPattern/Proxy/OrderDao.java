package com.zhou.java.DesignPattern.Proxy;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 13:42
 */
public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao 创建Order 成功!");
        return 1;
    }
}
