package com.example.demo.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Create 2021/12/27 by Gq
 */
public class FlyweightFactory {
    private static Map<String, Flyweight> flyweights = new HashMap<>();

    public static Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if(flyweight != null) {
            System.out.println("具体享元角色已被创建，直接使用");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
            System.out.println("创建新的享元角色");
        }
        return flyweight;
    }
}
