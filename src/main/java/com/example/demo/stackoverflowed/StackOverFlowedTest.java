package com.example.demo.stackoverflowed;

/**
 * Create By Gq
 * 2021/6/9 下午3:40
 * 虚拟机栈也有OutOfMemeryError
 * 测试让虚拟机栈出现异常：未成功
 * 运行参数： -Xmx20m -Xms20m -Xss160k
 * 创建线程测试： -Xmx20m -Xms20m -Xss2m
 */
public class StackOverFlowedTest {

    public static void main(String[] args) {
        for(int i = 0; i < 150000; i ++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(";;;" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("=-- End -----" + Thread.currentThread().getName());
                }
            });
            thread.start();
        }
    }

}
