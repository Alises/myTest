package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 * 具体命令， 关闭
 */
public class CloseCommand implements Command {
    private ElectricalApp electricalApp;

    @Override
    public void setReceiver(ElectricalApp electricalApp) {
        this.electricalApp = electricalApp;
    }

    @Override
    public void execute() {
        // 具体执行者
        electricalApp.close();
    }
}
