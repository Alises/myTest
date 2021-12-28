package com.example.demo.design.state.impl;

/**
 * Create 2021/12/28 by Gq
 * 具体状态类： 被控制
 */
public class ControlState implements State {
    /**
     * 移动
     * @param hero
     */
    @Override
    public void run(Hero hero) {
        System.out.println("英雄被控制，无法移动");
    }

    /**
     * 攻击
     */
    @Override
    public void attack(Hero hero) {
        System.out.println("英雄被控制，无法攻击");
    }

    /**
     * 清除异常状态
     */
    @Override
    public void clean(Hero hero) {
        System.out.println("英雄解除异常状态");
        hero.setState(new NomalState());
    }
}
