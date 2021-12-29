package com.example.demo.design.observer;

/**
 * Create 2021/12/29 by Gq
 */
public class ConcreteObserverB implements Observer {
    @Override
    public void response() {
        System.out.println("通知已收到，ConcreteObserverB将作出对应变更");
    }
}
