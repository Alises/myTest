package com.example.demo.design.decorator;

/**
 * 2019/12/26 create by Gq
 * 抽象变身
 */

public class Changer implements BoneDemon {

    protected BoneDemon boneDemon;

    Changer(BoneDemon boneDemon) {
        this.boneDemon = boneDemon;
    }

    @Override
    public void display() {
        boneDemon.display();
    }
}
