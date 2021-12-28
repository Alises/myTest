package com.example.demo.design.state.ext;

/**
 * Create 2021/12/28 by Gq
 */
public class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void changeState() {
        state.handle(this);
    }
}
