package com.example.demo.design.mediator;

/**
 * Create 2021/12/29 by Gq
 */
public class MediatorTest {

    public static void main(String[] args) {
        // 创建一个中介
        Mediator mediator = new ConcreteMediator();
        // 来三个人  并找到一个中介
        Colleague zhangSan = new ConcreteColleague("ZhangSan");
        Colleague liSi = new ConcreteColleague("LiSi");
        Colleague wangWu = new ConcreteColleague("WangWu");
        zhangSan.setMediator(mediator);
        liSi.setMediator(mediator);
        wangWu.setMediator(mediator);
        // 中介对应
        // 张三发言
        System.out.println("张三发言");
        zhangSan.send("大家好，我叫张三");
        System.out.println("-----------------------");
        // 李四发言
        System.out.println("李四发言");
        liSi.send("大家好，我叫李四");
        System.out.println("-----------------------");
        // 王五发言
        System.out.println("王五发言");
        wangWu.send("Hi、I`m WangWu");
        System.out.println("-----------------------");
    }
}
