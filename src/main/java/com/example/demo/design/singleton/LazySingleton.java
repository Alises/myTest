package com.example.demo.design.singleton;

/**
 * 2019/12/20 create by Gq
 * 懒汉式单例模式
 */

public class LazySingleton {
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * 普通单例模式
     */
//    public static LazySingleton getInstance() {
//        if(instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }


    /**
     * 带锁单例模式
     *
     * @return
     */
//    public static synchronized LazySingleton getInstance() {
//
//        if(instance == null) {
//
//            instance = new LazySingleton();
//
//        }
//
//        return instance;
//    }

    /**
     * 双重验证单例
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {

                if (instance == null) {

                    instance = new LazySingleton();

                }
            }
        }

        return instance;
    }
}
