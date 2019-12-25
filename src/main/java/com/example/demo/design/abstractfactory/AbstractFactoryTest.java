package com.example.demo.design.abstractfactory;

/**
 * 2019/12/24 create by Gq
 */

public class AbstractFactoryTest {

    public static void main(String[] args) {
        Farm xtFarm = new XTFarm();
        Animal xtCow = xtFarm.createAnimal();
        xtCow.show();
        Plant xtApple = xtFarm.createPlant();
        xtApple.show();

        Farm tyFarm = new TYFarm();
        Animal tyCow = tyFarm.createAnimal();
        tyCow.show();
        Plant tyApple = tyFarm.createPlant();
        tyApple.show();
    }
}
