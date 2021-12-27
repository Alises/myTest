package com.example.demo.design.strategy;

/**
 * Create 2021/12/27 by Gq
 * 具体策略角色
 */
public class ConcreteStrategy implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略模式1方法被调用");
    }
}
