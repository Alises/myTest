package com.example.demo.design.decorator;

/**
 * 2019/12/26 create by Gq
 */

public class DecoratorTest {

    public static void main(String[] args) {
        BoneDemon original = new Original();
        original.display();
        System.out.println("===============");
        BoneDemon gril = new Gril(original);
        gril.display();
        System.out.println("===============");
        BoneDemon oldMan = new OldMan(original);
        oldMan.display();
        System.out.println("===============");
        BoneDemon oldWomen = new OldWomen(original);
        oldWomen.display();
    }
}
