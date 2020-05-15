package com.zhou.java.DesignPattern.DecoratorPattern;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/23 10:46
 */
public class RedGemDecorator implements GemDecorator {

    private Equip equip;

    public RedGemDecorator(Equip equip) {
        this.equip = equip;
    }

    @Override
    public int calculateAttack() {
        return 15 + equip.calculateAttack();
    }

    @Override
    public String description() {
        return equip.description() + "红宝石";
    }
}
