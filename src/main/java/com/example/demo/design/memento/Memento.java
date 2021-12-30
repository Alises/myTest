package com.example.demo.design.memento;

/**
 * Create 2021/12/30 by Gq
 * 备忘录角色
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
