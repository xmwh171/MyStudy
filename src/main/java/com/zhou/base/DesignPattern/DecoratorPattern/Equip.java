package com.zhou.base.DesignPattern.DecoratorPattern;

/**
 * @Description  装备
 * @Author xiaohu
 * @Date 2019/7/23 10:40
 */
public interface Equip {

    /**
     * 计算攻击值
     * @return
     */
    int calculateAttack();

    /**
     * 装备描述
     * @return
     */
    String description();
}
