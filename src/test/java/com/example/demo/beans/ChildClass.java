package com.example.demo.beans;

/**
 * Create 2020/8/7 By Gq
 */
public class ChildClass extends ParentClass implements InterfaceTest{
    public ChildClass() {
        System.out.println("我是儿子。。。。");
    }

    public void sayHello() {
        System.out.println("hello !");
    }

}
