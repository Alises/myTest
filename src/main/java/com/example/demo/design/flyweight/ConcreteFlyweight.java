package com.example.demo.design.flyweight;

/**
 * Create 2021/12/27 by Gq
 * 具体的享元角色
 */
public class ConcreteFlyweight implements Flyweight {
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元角色" + key + "被创建");
    }

    @Override
    public void operation(UnsharedFlyweight unshared) {
        System.out.println("具体享元" + key + "被调用");
        System.out.println("非享元信息是" + unshared.getInfo());
    }
}
