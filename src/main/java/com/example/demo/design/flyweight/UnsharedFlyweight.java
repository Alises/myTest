package com.example.demo.design.flyweight;

/**
 * Create 2021/12/27 by Gq
 */
public class UnsharedFlyweight {
    private String info;

    public UnsharedFlyweight(String info) {
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }
}
