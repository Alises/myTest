package com.example.demo.design.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Create 2021/12/29 by Gq
 * 具体中介者类
 */
public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void relay(Colleague colleague, String msg) {
        for (Colleague col : colleagues) {
            if(!col.equals(colleague)) {
                col.receive(msg);
            }
        }
    }
}
