package com.example.demo.design.proxy;

/**
 * 2019/12/24 create by Gq
 */

public class Proxy implements Subject {
    private RealSubject subject;

    @Override
    public void request() {
        if(subject == null) {
            subject = new RealSubject();
        }
        beforeRequest();
        subject.request();
        afterRequest();
    }

    private void beforeRequest() {
        System.out.println("处理前需要处理的事情");
    }

    private void afterRequest() {
        System.out.println("处理后需要处理的事情");
    }
}
