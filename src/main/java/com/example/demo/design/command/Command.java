package com.example.demo.design.command;

/**
 * Create 2021/12/27 by Gq
 * 命令抽象类
 */
public interface Command {
    void setReceiver(ElectricalApp electricalApp);

    void execute();
}
