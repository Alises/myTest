package com.example.demo.design.mediator;

/**
 * Create 2021/12/29 by Gq
 */
public abstract class Colleague {
    protected String name;
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        mediator.register(this);
    }

    public abstract void receive(String msg);

    public abstract void send(String msg);
}
