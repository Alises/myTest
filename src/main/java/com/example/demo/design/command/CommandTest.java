package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 */
public class CommandTest {
    public static void main(String[] args) {
        // 家用电器
        ElectricalApp tv = new TVElectricalApp();
        ElectricalApp radio = new RadioElectricalApp();

        // 创建一个新的命令
        Command open = new OpenCommand();
        // 此命令对谁使用
        open.setReceiver(tv);
        // 执行命令
        open.execute();

        open.setReceiver(radio);
        open.execute();
        // 工作命令
        Command worke = new WorkeCommand();
        worke.setReceiver(tv);
        worke.execute();

        worke.setReceiver(radio);
        worke.execute();

        // 关闭命令
        Command close = new CloseCommand();
        close.setReceiver(tv);
        close.execute();

        close.setReceiver(radio);
        close.execute();
    }
}
