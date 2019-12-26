package com.example.demo.design.decorator;

/**
 * 2019/12/26 create by Gq
 */

public class OldWomen extends Changer {

    OldWomen(BoneDemon boneDemon) {
        super(boneDemon);
    }

    @Override
    public void display() {
        setChanger();
        super.display();
    }

    public void setChanger() {
        ((Original) super.boneDemon).setName("老太太身份");
    }
}
