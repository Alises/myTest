package com.example.demo.design.adapter;

/**
 * 2019/12/24 create by Gq
 * 转换器  将需要访问的不兼容的方法通过这个类变成兼容方法
 */

public class Adapter extends Adaptee implements Target{

    @Override
    public void request() {
        realRequest();
    }

}
