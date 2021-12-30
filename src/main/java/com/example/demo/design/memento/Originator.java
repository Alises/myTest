package com.example.demo.design.memento;

/**
 * Create 2021/12/30 by Gq
 * 发起人角色
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemnto() {
        return new Memento(this.state);
    }

    public void restoreMemento(Memento m) {
        setState(m.getState());
    }
}
