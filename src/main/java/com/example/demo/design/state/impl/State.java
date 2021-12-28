package com.example.demo.design.state.impl;

/**
 * Create 2021/12/28 by Gq
 * 抽象状态的接口
 */
public interface State {
    /**
     * 移动
     */
    void run(Hero hero);

    /**
     * 攻击
     */
    void attack(Hero hero);

    /**
     * 清除异常状态
     */
    void clean(Hero hero);
}
