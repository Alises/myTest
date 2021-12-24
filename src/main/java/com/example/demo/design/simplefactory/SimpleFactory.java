package com.example.demo.design.simplefactory;

/**
 * Create 2021/12/23 by Gq
 */
public class SimpleFactory {

    public static Product create(int type) {
        switch (type) {
            case 0:
                return new Product1();
            case 1:
                return new Product2();
            default:
                return null;
        }

    }
}
