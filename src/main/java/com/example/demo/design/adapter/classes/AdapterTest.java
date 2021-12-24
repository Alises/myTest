package com.example.demo.design.adapter.classes;

/**
 * 2019/12/24 create by Gq
 * 类结构模式测试方法
 */

public class AdapterTest {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
