package com.example.demo.design.prototype;

/**
 * 2019/12/24 create by Gq
 */

public class PrototypeTest implements Cloneable {
    private int age;
    private String name;

    public PrototypeTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(this.name + " .. " + this.age);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
