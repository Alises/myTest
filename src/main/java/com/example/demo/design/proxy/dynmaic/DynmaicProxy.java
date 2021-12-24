package com.example.demo.design.proxy.dynmaic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create 2021/12/24 by Gq
 */
public class DynmaicProxy implements InvocationHandler {
    private Object obj;

    DynmaicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(obj, args);
        return null;
    }
}
