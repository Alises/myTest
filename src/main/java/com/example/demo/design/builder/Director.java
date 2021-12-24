package com.example.demo.design.builder;

/**
 * 2019/12/24 create by Gq
 * 指挥者角色
 */

public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Product build() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        builder.buildPartD();

        return builder.getProduct();
    }
}
