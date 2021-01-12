package com.zhou.java.DesignPattern.Prototype;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 10:43
 */
public class bottle implements Cloneable {
    public wine wn;

    public bottle(wine wn) {
        this.wn = wn;
    }
    // 覆写clone()方法
    protected Object clone() throws CloneNotSupportedException {
        bottle newBtl = (bottle) super.clone();
        newBtl.wn = (wine) wn.clone();
        return newBtl;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        bottle bottle = new bottle(new wine());
        bottle bottle1 = (bottle) bottle.clone();

        System.out.println("bottle1.wine : " + bottle1.wn.getName() );
        bottle1.wn.setName("中国二锅头");

        System.out.println("bottle1.wine : " + bottle1.wn.getName() );
        System.out.println("bottle.wine : " + bottle.wn.getName());
    }
}

class wine implements Cloneable {
    int degree;
    String name="法国白兰地";

    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // 覆写clone()方法
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
