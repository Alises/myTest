package com.example.demo.design.strategy;

/**
 * Create 2021/12/27 by Gq
 * 策略模式测试类
 */
public class StrategyTest {
    public static void main(String[] args) {
        Strategy strategy = StrategyFactory.getStrategy(StrategyEnum.ONE);
        strategy.strategyMethod();
        Strategy strategy1 = StrategyFactory.getStrategy(StrategyEnum.TWO);
        strategy1.strategyMethod();
    }
}
