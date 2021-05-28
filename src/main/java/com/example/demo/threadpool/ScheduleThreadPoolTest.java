package com.example.demo.threadpool;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Create By Gq
 * 2021/5/28 下午5:23
 * ScheduleThreadPoolTest是一个延迟线程池，可指定核心线程数，线程最大数量为Integer.MAX_VALUE
 * 没有线程存活时间，为0
 * 工作队列为DelayedWorkQueue
 * schedule
 * scheduleAtFixedRate
 *
 */
public class ScheduleThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        /*
            schedule 执行一次，以指定延迟时间运行。
         */
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + " 我是一个定时任务 " + Instant.now());
//            }
//        }, 3L, TimeUnit.SECONDS);
//
        /*
            initialDelay: 第一次延迟执行时间(初始化延迟)，
            period: 两次执行任务的最小间隔时间,从开始执行计算时间，不管执行时间长短
            多次执行
         */
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + " 我是一个定时任务，开始执行 " + Instant.now());
//                //休息3s
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " 我是一个定时任务，执行完毕  ======= " + Instant.now());
//            }
//        }, 1L, 5L, TimeUnit.SECONDS);

        /*
            initialDelay: 第一次延迟执行时间
            delay: 两次执行之间的时间间隔，从线程执行结束开始计算
         */
//        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + " 我是一个定时任务，开始执行 " + Instant.now());
//                //休息3s
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " 我是一个定时任务，执行完毕  ======= " + Instant.now());
//            }
//        }, 3L, 5L, TimeUnit.SECONDS);

        /*
            普通线程池执行逻辑
         */
        scheduledExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 我是一个定时任务 " + Instant.now());
            }
        });

    }
}
