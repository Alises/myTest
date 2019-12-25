package com.example.demo.design.singleton;

/**
 * 2019/12/20 create by Gq
 * 饿汉式单例模式
 */

public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance() {

        return instance;
    }

}
