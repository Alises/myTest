package com.example.demo.design.proxy.dynmaic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Create 2021/12/24 by Gq
 * 代理模式的扩展： 动态代理
 */
public class DynmaicProxyTest {

    public static void main(String[] args) {

        InvocationHandler handler = new DynmaicProxy(new RealSubject());
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), Subject.class.getInterfaces(), handler);
        subject.request(1);
    }
}
