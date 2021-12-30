package com.example.demo.beans;

/**
 * Create 2020/8/7 By Gq
 */
public class ParentClass implements InterfaceTest {
    private Integer age;

    public ParentClass() {
        System.out.println("我是爸爸。。。");
    }

    protected void test() {
        System.out.println("test in parent");
    }

    @Override
    public void interfaceMethod() {

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
