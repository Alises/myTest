package com.example.demo.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Create 2021/12/27 by Gq
 * 策略模式工厂   可扮演 环境（Context）类
 */
public class StrategyFactory {
    private final static Map<StrategyEnum, Strategy> map = new HashMap<>();

    static {
        map.put(StrategyEnum.ONE, new ConcreteStrategy());
        map.put(StrategyEnum.TWO, new ConcreteStrategy2());
    }

    public static Strategy getStrategy(StrategyEnum key) {
        Strategy strategy = map.get(key);
        if(strategy == null) {
            // 如果为空 默认一个
            strategy = new ConcreteStrategy();
        }

        return strategy;
    }
}
