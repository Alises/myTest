package com.example.demo.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create 2021/12/29 by Gq
 * 抽象目标类
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    // 此方法可带有参数 通知最新的数值变化
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.response();
        }
    }
}
