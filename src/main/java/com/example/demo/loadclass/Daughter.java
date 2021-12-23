package com.example.demo.loadclass;

/**
 * Create By Gq
 * 2021/6/8 下午2:57
 */
public class Daughter extends Parent {
    static {
        System.out.println("-------- Daughter init ---------");
    }

    public static String DAUGHTER_VALUE = "daughter value";

    public static final String DAUGHTER_STATIC_VALUE = "daughter static value";

    public static String getDaughterValue() {
        return DAUGHTER_VALUE;
    }
}
