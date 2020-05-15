package com.zhou.java.DesignPattern.DecoratorPattern;

/**
 * @Description  武器
 * @Author xiaohu
 * @Date 2019/7/23 10:43
 */
public class ArmsEquip implements Equip {

    @Override
    public int calculateAttack() {
        return 20;
    }

    @Override
    public String description() {
        return "暴风大剑";
    }
}
