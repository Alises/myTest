package com.example.demo.design.state.impl;

/**
 * Create 2021/12/28 by Gq
 */
public class DieState implements State {
    /**
     * 移动
     */
    @Override
    public void run(Hero hero) {
        System.out.println("英雄死亡，无法移动~");
    }

    /**
     * 攻击
     */
    @Override
    public void attack(Hero hero) {
        System.out.println("英雄死亡，无法攻击~");
    }

    /**
     * 清除异常状态
     */
    @Override
    public void clean(Hero hero) {
        System.out.println("英雄死亡，无法清除状态~");
    }
}
