package com.example.demo.design.proxy.dynmaic;

/**
 * Create 2021/12/24 by Gq
 */
public class RealSubject implements Subject {

    @Override
    public void request(int i) {
        System.out.println(" 执行此方法， 参数 i = "+i);
    }
}
