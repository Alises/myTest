package com.example.demo.design.visitor;

import java.util.Random;

/**
 * Create 2021/12/30 by Gq
 */
public class Engineer extends Staff {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 一年的代码量
    public int getCodeLines() {
        return new Random().nextInt(10) * 1000;
    }
}
