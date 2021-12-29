package com.example.demo.design.observer;

/**
 * Create 2021/12/29 by Gq
 * 观察者模式测试类
 */
public class ObserverTest {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        init(concreteSubject);
        concreteSubject.setData(3);
    }

    private static void init(Subject subject) {
        subject.add(new ConcreteObserver());
        subject.add(new ConcreteObserverB());
    }
}
