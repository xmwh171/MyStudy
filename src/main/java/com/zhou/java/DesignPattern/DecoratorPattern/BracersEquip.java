package com.zhou.java.DesignPattern.DecoratorPattern;

/**
 * @Description 护腕
 * @Author xiaohu
 * @Date 2019/7/23 10:44
 */
public class BracersEquip implements Equip {


    @Override
    public int calculateAttack() {
        return 10;
    }

    @Override
    public String description() {
        return "铁血护腕";
    }
}
