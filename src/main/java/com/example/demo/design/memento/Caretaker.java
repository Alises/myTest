package com.example.demo.design.memento;

/**
 * Create 2021/12/30 by Gq
 * 管理类
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
