package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 * 具体命令实现
 */
public class OpenCommand implements Command {
    // 接收者
    private ElectricalApp electricalApp;

    @Override
    public void setReceiver(ElectricalApp electricalApp) {
        this.electricalApp = electricalApp;
    }

    @Override
    public void execute() {
        // 接收者执行相关功能
        electricalApp.open();
    }
}
