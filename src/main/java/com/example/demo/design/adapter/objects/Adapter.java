package com.example.demo.design.adapter.objects;

/**
 * Create 2021/12/24 by Gq
 * 适配器角色   实现需要转换的目标
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.realRequest();
    }
}
