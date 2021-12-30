package com.example.demo.design.memento;

/**
 * Create 2021/12/30 by Gq
 */
public class MementoTest {

    public static void main(String[] args) {
        // 发起人
        Originator or = new Originator();
        // 管理类
        Caretaker ck = new Caretaker();
        or.setState("C1");
        System.out.println("当前设置状态为：" + or.getState());
        // 保存备忘录
        ck.setMemento(or.createMemnto());
        System.out.println("保存当前状态....");
        or.setState("C2");
        System.out.println("当前设置状态为：" + or.getState());
        System.out.println("状态错了，撤销一次....");
        or.restoreMemento(ck.getMemento());
        System.out.println("已撤销：当前状态为：" + or.getState());
    }
}
