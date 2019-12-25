package com.example.demo.design.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019/12/24 create by Gq
 */

public enum EnumSingleton {
    INSTANCE;

    private Map<String,String> map;

    EnumSingleton() {
        map = new HashMap<>();
    }

    public Map<String,String> getMap() {

        return map;
    }
}