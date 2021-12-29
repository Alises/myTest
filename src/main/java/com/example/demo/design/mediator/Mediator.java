package com.example.demo.design.mediator;

/**
 * Create 2021/12/29 by Gq
 * 中介者接口
 */
public interface Mediator {

    void register(Colleague colleague);

    void relay(Colleague colleague, String msg);
}
