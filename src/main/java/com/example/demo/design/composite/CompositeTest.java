package com.example.demo.design.composite;

/**
 * Create 2020/3/23 By Gq
 */
public class CompositeTest {

    public static void main(String[] args) {
        Bags bigBag = new Bags("大袋子");
        Goods goods1 = new Goods("茶叶", 120, 10);
        bigBag.add(goods1);
        Goods goods2 = new Goods("鸡蛋", 3, 3.2f);
        bigBag.add(goods2);
        bigBag.show();
        System.out.println("总计：" + bigBag.calculation()+ "元");
    }
}
