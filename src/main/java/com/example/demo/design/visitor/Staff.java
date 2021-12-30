package com.example.demo.design.visitor;


import java.util.Random;

/**
 * Create 2021/12/30 by Gq
 */
public abstract class Staff {
    protected String name;
    protected int kpi;

    public Staff(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    public abstract void accept(Visitor visitor);
}
