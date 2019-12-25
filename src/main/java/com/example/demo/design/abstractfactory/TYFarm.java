package com.example.demo.design.abstractfactory;

/**
 * 2019/12/24 create by Gq
 */

public class TYFarm implements Farm {
    @Override
    public Animal createAnimal() {
        System.out.println("太原农场 小牛出生了。。。");
        return new Cow();
    }

    @Override
    public Plant createPlant() {
        System.out.println("太原农场 苹果熟了。。。");
        return new Apple();
    }
}
