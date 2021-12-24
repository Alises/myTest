package com.example.demo.design.adapter.objects;

/**
 * Create 2021/12/24 by Gq
 * 适配器对象模式测试类
 * 对象结构模式比类结构模式耦合更小：通过聚合的方式代替继承的方式
 */
public class AdapterObjectTest {

    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}
