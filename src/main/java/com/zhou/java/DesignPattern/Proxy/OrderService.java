package com.zhou.java.DesignPattern.Proxy;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 13:43
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;
    public OrderService(){
    //如果使用Spring 应该是自动注入的
    //我们为了使用方便，在构造方法中将orderDao 直接初始化了
        orderDao = new OrderDao();
    }
    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService 调用orderDao 创建订单");
        return orderDao.insert(order);
    }
}
