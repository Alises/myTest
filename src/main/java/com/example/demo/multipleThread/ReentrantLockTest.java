package com.example.demo.multipleThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create 2021/11/26 by Gq
 */
public class ReentrantLockTest {
    private static volatile int COUNT = 0;

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(ReentrantLockTest::add);
        Thread t2 = new Thread(ReentrantLockTest::add);
        Thread t3 = new Thread(ReentrantLockTest::add);
        t1.start();
        t2.start();
        t3.start();

        long end = System.currentTimeMillis();

        System.out.println(COUNT);
        System.out.println(end - start);
    }


    private static void add() {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

}
