package com.example.demo.loadclass;

/**
 * Create By Gq
 * 2021/6/8 下午2:39
 */
public class Children extends Parent {
    static {
        System.out.println("-------- Children init ---------");
    }
    public static String CHILDREN_VALUE = "children value";

    public static final String STATIC_CHILDREN_VALUE = "children static value";

    public String getChildValue() {
        return CHILDREN_VALUE;
    }

    public String getParentValue() {
        return PARENT_VALUE;
    }
}
