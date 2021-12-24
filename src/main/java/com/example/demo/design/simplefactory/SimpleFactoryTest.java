package com.example.demo.design.simplefactory;

/**
 * Create 2021/12/23 by Gq
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        Product product = SimpleFactory.create(SimpleFactoryConstant.PRODUCT_A);
        product.show();
        Product product2 = SimpleFactory.create(SimpleFactoryConstant.PRODUCT_B);
        product2.show();
    }
}
