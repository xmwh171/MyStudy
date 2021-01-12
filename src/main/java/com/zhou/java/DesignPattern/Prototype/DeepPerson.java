package com.zhou.java.DesignPattern.Prototype;

import java.io.Serializable;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/6/29 10:47
 */
public class DeepPerson implements Serializable {
    private int a;
    private int[] b;

    public DeepPerson() {
    }

    public DeepPerson(int a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }

}
