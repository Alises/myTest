package com.example.demo.design.singleton;

/**
 * 2019/12/20 create by Gq
 * 静态内部类单例模式
 */

public class InneClassSingleton {
    private InneClassSingleton(){}

    private static class SingletonHodler {
        private static InneClassSingleton INSTANCE = new InneClassSingleton();
    }

    public InneClassSingleton getInstance() {
        return SingletonHodler.INSTANCE;
    }
}