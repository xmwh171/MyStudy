package com.zhou.base.DesignPattern.DecoratorPattern;

/**
 * @Description 鞋子
 * @Author xiaohu
 * @Date 2019/7/23 10:45
 */
public class ShoesEquip implements Equip {
    @Override
    public int calculateAttack() {
        return 2;
    }

    @Override
    public String description() {
        return "五速鞋";
    }
}
