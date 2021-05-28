package com.example.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By Gq
 * 2021/5/28 下午5:16
 * newSingleThreadExecutor为核心线程数量为1，最大线程数为1，在ThreadPoolExecutor构造方法外嵌套FinalizableDelegatedExecutorService
 * 任务队列为LinkedBlockingQueue无界队列
 */
public class SignleThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 50; i ++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " ===> 打印参数： " + Thread.currentThread().getId());
                }
            });
        }
    }
}
