package com.example.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create By Gq
 * 2021/5/28 下午5:06
 * CachedThreadPool是一个没有核心线程的线程池，线程池最大数量为Integer.MAX_VALUE
 * 有任务提交且没有空闲线程时，创建新线程。默认线程空闲存活时间为60S
 * 工作队列为同步队列SynchronousQueue，任务提交时有线程接受，否则提交处于阻塞状态。
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i ++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ===> 打印参数： " + Thread.currentThread().getId());
                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "End.");
                }
            });
        }
    }
}
