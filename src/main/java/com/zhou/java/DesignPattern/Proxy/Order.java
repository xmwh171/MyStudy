package com.zhou.java.DesignPattern.Proxy;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 13:42
 */
public class Order {

    private Object orderInfo;
    private Long createTime;
    private String id;
    public Object getOrderInfo() {
        return orderInfo;
    }
    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
