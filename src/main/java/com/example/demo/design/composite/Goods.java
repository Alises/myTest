package com.example.demo.design.composite;

/**
 * Create 2020/3/23 By Gq
 */
public class Goods implements Articles {
    private String name;    //名称
    private int quantity;   //数量
    private float price;    //价格

    public Goods(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public float calculation() {
        return quantity * price;
    }

    @Override
    public void show() {
        System.out.println(name +"(数量：" + quantity + ", 单价：" + price + "元, 合计：" + calculation() + "元)");
    }
}
