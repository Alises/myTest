package com.example.demo.design.template;

/**
 * Create 2021/12/27 by Gq
 */
public class ChildTemplate extends AbstractTemplate {
    @Override
    protected void method1() {
        System.out.println("子类1实现方法method1被调用");
    }

    @Override
    protected void method2() {
        System.out.println("子类1实现方法method2被调用");
    }

    @Override
    protected void method3() {
        System.out.println("子类1实现方法method3被调用");
    }
}
