package com.example.demo.design.singleton;

import java.util.Map;

/**
 * Create 2021/12/23 by Gq
 */
public class SingletonTest {

    public static void main(String[] args) {
//        InneClassSingleton instance = InneClassSingleton.getInstance();
//        instance.say(" world ");
        Map<String, String> map = EnumSingleton.INSTANCE.getMap();
        System.out.println(map);
    }
}
