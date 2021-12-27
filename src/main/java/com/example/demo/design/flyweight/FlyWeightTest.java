package com.example.demo.design.flyweight;

/**
 * 2020/1/17 create by Gq
 */

public class FlyWeightTest {


    public static void main(String[] args) {
        Flyweight a = FlyweightFactory.getFlyweight("A");
        Flyweight a1 = FlyweightFactory.getFlyweight("A");
        Flyweight b = FlyweightFactory.getFlyweight("B");
        Flyweight b1 = FlyweightFactory.getFlyweight("B");
        a.operation(new UnsharedFlyweight("a第一次被调用"));
        a1.operation(new UnsharedFlyweight("a第二次被调用"));
        b.operation(new UnsharedFlyweight("b第一次被调用"));
        b1.operation(new UnsharedFlyweight("b第二次被调用"));
    }
}
