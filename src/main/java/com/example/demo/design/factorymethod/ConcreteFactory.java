package com.example.demo.design.factorymethod;

/**
 * 2019/12/24 create by Gq
 */

public class ConcreteFactory implements AbstractFactory {

    @Override
    public Product createProduct() {

        System.out.println("具体工厂--> 创建具体产品");

        return new ConcreteProduct();
    }
}
