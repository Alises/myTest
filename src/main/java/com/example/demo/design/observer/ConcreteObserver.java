package com.example.demo.design.observer;

/**
 * Create 2021/12/29 by Gq
 * 具体观察者
 */
public class ConcreteObserver implements Observer {
    @Override
    public void response() {
        System.out.println("变动已收到，ConcreteObserver 将作出对应变更");
    }
}
