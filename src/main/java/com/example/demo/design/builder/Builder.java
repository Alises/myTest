package com.example.demo.design.builder;

/**
 * 2019/12/24 create by Gq
 */

public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public abstract void buildPartD();

    public Product getProduct() {

        return product;
    }
}
