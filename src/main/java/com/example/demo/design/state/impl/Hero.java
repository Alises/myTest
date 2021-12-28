package com.example.demo.design.state.impl;

import java.util.concurrent.TimeUnit;

/**
 * Create 2021/12/28 by Gq
 * 环境类
 */
public class Hero {
    private volatile State state;

    public Hero() {
        this.state = new NomalState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void run() {
        state.run(this);
    }

    public void attack() {
        state.attack(this);
    }

    public void clean() {
        state.clean(this);
    }

    /**
     * 被控制 并在1秒后解除控制
     */
    public void control() {
        state = new ControlState();
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 1秒后解除控制 恢复正常状态
        System.out.println("控制状态解除++");
        state = new NomalState();
    }

    /**
     * 英雄死亡 2秒后重生
     */
    public void die() {
        state = new DieState();
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("英雄重生------------");
        // 2秒后解除控制 恢复正常状态
        state = new NomalState();
    }
}
