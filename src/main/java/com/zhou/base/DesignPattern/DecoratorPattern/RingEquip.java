package com.zhou.base.DesignPattern.DecoratorPattern;

/**
 * @Description  戒指
 * @Author xiaohu
 * @Date 2019/7/23 10:44
 */
public class RingEquip implements Equip {
    @Override
    public int calculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "多兰戒";
    }
}
