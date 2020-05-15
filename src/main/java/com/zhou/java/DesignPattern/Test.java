package com.zhou.java.DesignPattern;

import com.zhou.java.DesignPattern.DecoratorPattern.*;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/7/23 10:34
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(" 一个镶嵌2颗红宝石，1颗蓝宝石的鞋");
        RedGemDecorator equip = new RedGemDecorator(new RedGemDecorator(new BlueGemDecorator(new ShoesEquip())));
        System.out.println("攻击力  : " + equip.calculateAttack());
        System.out.println("描述 :" + equip.description());
        System.out.println("-------");
        // 一个镶嵌1颗红宝石，1颗蓝宝石的武器
        System.out.println(" 一个镶嵌1颗红宝石，1颗蓝宝石,1颗黄宝石的武器");
        equip = new RedGemDecorator(new BlueGemDecorator(new YellowGemDecorator(new ArmsEquip())));
        System.out.println("攻击力  : " + equip.calculateAttack());
        System.out.println("描述 :" + equip.description());
        System.out.println("-------");

    }
}
