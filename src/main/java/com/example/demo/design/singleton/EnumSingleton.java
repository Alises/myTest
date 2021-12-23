package com.example.demo.design.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019/12/24 create by Gq
 * 利用枚举方式
 */

public enum EnumSingleton {
    INSTANCE;

    private Map<String,String> map;

    EnumSingleton() {
        map = new HashMap<>();
    }

    // 单例类的方法
    // EnumSingleton.INSTANCE.getMap();
    public Map<String,String> getMap() {

        return map;
    }
}