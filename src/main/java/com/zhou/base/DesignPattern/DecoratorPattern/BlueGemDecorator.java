package com.zhou.base.DesignPattern.DecoratorPattern;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/23 10:46
 */
public class BlueGemDecorator implements GemDecorator {

    private Equip equip;

    public BlueGemDecorator(Equip equip) {
        this.equip = equip;
    }

    @Override
    public int calculateAttack() {
        return 5+equip.calculateAttack();
    }

    @Override
    public String description() {
        return equip.description()+"蓝宝石";
    }
}
