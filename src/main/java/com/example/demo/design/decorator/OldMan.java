package com.example.demo.design.decorator;

/**
 * 2019/12/26 create by Gq
 * 变身恶魔
 */

public class OldMan extends Changer {


    OldMan(BoneDemon boneDemon) {
        super(boneDemon);
    }

    @Override
    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((Original)super.boneDemon).setName("老头身份");
    }
}
