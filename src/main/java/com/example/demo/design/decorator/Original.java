package com.example.demo.design.decorator;

/**
 * 2019/12/26 create by Gq
 */

public class Original implements BoneDemon {
    private String name = "白骨精";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("白骨精原身：" + name);
    }
}
