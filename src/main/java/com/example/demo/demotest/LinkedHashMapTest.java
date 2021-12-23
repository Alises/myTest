package com.example.demo.demotest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Create By Gq
 * 2021/6/15 下午3:28
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {

        LinkedHashMap<String, String> lmap = new LinkedHashMap<>(16, 0.75f, true);
        lmap.put("key", "value");
        lmap.put("key1", "value");
        lmap.put("key2", "value");
        lmap.put("key3", "value");
        lmap.put("key4", "value");
        System.out.println(lmap);
        lmap.put("key1", "value2");
        System.out.println(lmap);
        Set<Map.Entry<String, String>> entries = lmap.entrySet();
        for (Map.Entry<String, String> entry : entries) {

            System.out.println(entry.getKey() + "----" + entry.getValue());
        }
    }
}
