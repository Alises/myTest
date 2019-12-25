package com.example.demo.design.factorymethod;

/**
 * 2019/12/24 create by Gq
 */

public class FactoryTest {


    public static void main(String[] args) {
        AbstractFactory abf = new ConcreteFactory();
        Product product = abf.createProduct();
        product.show();
    }
}
