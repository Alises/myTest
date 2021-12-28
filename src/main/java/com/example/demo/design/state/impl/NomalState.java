package com.example.demo.design.state.impl;

/**
 * Create 2021/12/28 by Gq
 * 具体状态类： 正常
 */
public class NomalState implements State {
    /**
     * 移动
     */
    @Override
    public void run(Hero hero) {
        System.out.println("英雄正常向目标点移动....");
    }

    /**
     * 攻击
     */
    @Override
    public void attack(Hero hero) {
        System.out.println("英雄向目标发起攻击....");
    }

    /**
     * 清除异常状态
     */
    @Override
    public void clean(Hero hero) {
        System.out.println("英雄没有异常状态，不用解除状态....");
    }
}
