package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 * 具体命令角色： 工作
 */
public class WorkeCommand implements Command {
    private ElectricalApp electricalApp;

    @Override
    public void setReceiver(ElectricalApp electricalApp) {
        this.electricalApp = electricalApp;
    }

    @Override
    public void execute() {
        electricalApp.worke();
    }
}
