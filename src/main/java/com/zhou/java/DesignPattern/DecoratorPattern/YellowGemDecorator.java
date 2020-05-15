package com.zhou.java.DesignPattern.DecoratorPattern;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/23 10:46
 */
public class YellowGemDecorator implements GemDecorator {

    private Equip equip;

    public YellowGemDecorator(Equip equip) {
        this.equip = equip;
    }

    @Override
    public int calculateAttack() {
        return 10 + equip.calculateAttack();
    }

    @Override
    public String description() {
        return equip.description() + "黄宝石";
    }
}
