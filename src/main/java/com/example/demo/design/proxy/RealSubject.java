package com.example.demo.design.proxy;

/**
 * 2019/12/24 create by Gq
 */

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("真实处理方法。。。。。");
    }
}
