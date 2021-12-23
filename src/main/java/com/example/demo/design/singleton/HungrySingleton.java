package com.example.demo.design.singleton;

/**
 * 2019/12/20 create by Gq
 * 饿汉式单例模式
 * 线程安全
 * 因为在类加载时，触发实例化
 */

public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance() {

        return instance;
    }

}

/**
 * 第二种方法
 * 利用静态代码块进行初始化
 */
//public class HungrySingleton {
//    private static HungrySingleton instance;
//
//    private HungrySingleton(){}
//    static {
//         instance = new HungrySingleton();
//    }
//
//    public static HungrySingleton getInstance() {
//        return instance;
//    }
//}
