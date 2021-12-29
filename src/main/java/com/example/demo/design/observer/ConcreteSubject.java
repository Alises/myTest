package com.example.demo.design.observer;

/**
 * Create 2021/12/29 by Gq
 */
public class ConcreteSubject extends Subject {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        // 数值变更后通知观察者
        notifyObservers();
    }
}
