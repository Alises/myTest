package com.example.demo.design.state.ext;

/**
 * Create 2021/12/28 by Gq
 */
public class ConcreteStateA extends State {
    @Override
    protected void handle(Context context) {
        System.out.println("当前状态为 A");
        context.setState(new ConcreteStateB());
    }
}
