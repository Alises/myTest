package com.example.demo.loadclass;

/**
 * Create By Gq
 * 2021/6/8 下午2:35
 */
public class Parent extends GrandPa {
    static {
        System.out.println("------ parent init --------");
    }

    protected static String PARENT_VALUE = "parent value";

    public static final String STATIC_PARENT_VALUE = "parent static value";

    public static String getParnetValue() {
        return PARENT_VALUE;
    }
}
