package com.example.demo.design.state.impl;

import java.util.concurrent.TimeUnit;

/**
 * Create 2021/12/28 by Gq
 */
public class StateImplTest {

    private static volatile int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        Hero hero = new Hero();

        // 英雄移动的线程
        Thread runThread = new Thread(() -> {
            for(;;) {
                hero.run();
                // 每0.5秒移动一次
                try {
                    TimeUnit.MILLISECONDS.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 退出
                if(flag == -1) break;
            }
        });

        // 英雄攻击的线程
        Thread attack = new Thread(() -> {
            for(;;) {
                hero.attack();
                // 每0.5秒攻击一次
                try {
                    TimeUnit.MILLISECONDS.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 退出
                if(flag == -1) break;
            }
        });

        // 英雄解除异常状态线程
        Thread clean = new Thread(() -> {
            for (;;) {
                hero.clean();
                // 每1.5秒解除一次
                try {
                    TimeUnit.MILLISECONDS.sleep(1500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 退出
                if(flag == -1) break;
            }
        });
        runThread.start();
        attack.start();
        clean.start();

        for (int i = 0; i < 5; i++) {
            // 每3秒后 被控制一次 控制5次
            TimeUnit.SECONDS.sleep(3);
            System.out.println("英雄受到控制。。。。。 " +  i);
            hero.control();
        }

        // 5秒后 进入死亡状态
        TimeUnit.SECONDS.sleep(5);
        hero.die();
        // 3秒后结束线程
        TimeUnit.SECONDS.sleep(3);
        flag = -1;
        runThread.join();
        attack.join();
        clean.join();
        System.out.println("------------------结束---------------------");
    }


}
