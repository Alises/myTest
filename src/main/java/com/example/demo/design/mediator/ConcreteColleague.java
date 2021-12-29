package com.example.demo.design.mediator;

/**
 * Create 2021/12/29 by Gq
 * 具体同事类
 */
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(String name) {
        this.name = name;
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " 接收到消息：" + msg);
    }

    @Override
    public void send(String msg) {
        mediator.relay(this, msg);
    }
}
