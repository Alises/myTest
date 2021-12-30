package com.example.demo.design.visitor;

import java.util.Random;

/**
 * Create 2021/12/30 by Gq
 * 经理类
 */
public class Manager extends Staff {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 一年做的产品量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
