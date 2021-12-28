package com.example.demo.design.state.ext;

/**
 * Create 2021/12/28 by Gq
 */
public class ConcreteStateB extends State {
    @Override
    protected void handle(Context context) {
        System.out.println("当前状态为B");
        context.setState(new ConcreteStateA());
    }
}
