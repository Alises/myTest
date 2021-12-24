package com.example.demo.design.builder;

/**
 * 2019/12/24 create by Gq
 */

public class BuilderTest {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.build();
        product.show();
    }
}
