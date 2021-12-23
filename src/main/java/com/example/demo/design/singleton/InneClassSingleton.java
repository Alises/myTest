package com.example.demo.design.singleton;

/**
 * 2019/12/20 create by Gq
 * 静态内部类单例模式
 */

public class InneClassSingleton {
    private InneClassSingleton(){}

    private static class SingletonHodler {
        static {
            System.out.println("内部类加载");
        }
        private static InneClassSingleton INSTANCE = new InneClassSingleton();
    }

    public static InneClassSingleton getInstance() {
        return SingletonHodler.INSTANCE;
    }

    // 测试懒加载方法， 在未调用获取单例时 内部类不加载
    public static void sayHello() {
        System.out.println(" hello～ ");
    }

    public void say(String str) {
        System.out.println(" hello～ ," + str);
    }
}