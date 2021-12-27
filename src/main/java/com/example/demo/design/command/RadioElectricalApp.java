package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 * 具体接收者 收音机
 */
public class RadioElectricalApp implements ElectricalApp {
    @Override
    public void open() {
        System.out.println("收音机打开了....");
    }

    @Override
    public void close() {
        System.out.println("收音机关闭了....");
    }

    @Override
    public void worke() {
        System.out.println("收音机正在播放《你的月亮我的心》....");
    }
}
