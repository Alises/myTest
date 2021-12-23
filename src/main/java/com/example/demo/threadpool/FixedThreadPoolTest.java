package com.example.demo.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By Gq
 * 2021/5/28 下午4:55
 * FixedThreadPool是一个固定大小的线程池，核心线程数和线程池最大线程数相同
 * 没有非核心线程，所以存活时间为0
 * 是一个无界队列  LinkedBlockingQueue
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 50; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " === 》" + "打印参数: " + Thread.currentThread().getId());
                }
            });
        }
        //所有线程执行完毕后进行停止线程池
        executorService.shutdown();
        //立即停止所有线程，不管线程是否被执行或正在执行中
//        executorService.shutdownNow();
    }
}
