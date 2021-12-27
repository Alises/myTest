package com.example.demo.design.template;

/**
 * Create 2021/12/27 by Gq
 */
public abstract class AbstractTemplate {

    public void templateMethod() {
        method1();
        method2();
        method3();
        specificMethod();
    }

    public void specificMethod() {
        System.out.println("抽象类具体方法被调用");
    }

    protected abstract void method1();

    protected abstract void method2();

    protected abstract void method3();
}
