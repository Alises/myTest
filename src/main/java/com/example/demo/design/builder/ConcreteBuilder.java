package com.example.demo.design.builder;

/**
 * 2019/12/24 create by Gq
 */

public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("装配第一部分。。。。");
    }

    @Override
    public void buildPartB() {
        product.setPartB("装配第二部分。。。。");
    }

    @Override
    public void buildPartC() {
        product.setPartC("装配第三部分。。。。");
    }

    @Override
    public void buildPartD() {
        product.setPartD("装配第四部分。。。。");
    }
}
