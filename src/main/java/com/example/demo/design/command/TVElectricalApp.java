package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 * 具体接受者实现
 */
public class TVElectricalApp implements ElectricalApp {

    @Override
    public void open() {
        System.out.println("电视机打开了.....");
    }

    @Override
    public void close() {
        System.out.println("电视机关闭了.....");
    }

    @Override
    public void worke() {
        System.out.println("电视机开始播放《小猪佩奇》.....");
    }
}
