package com.github.zhangxin.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/26 11:48
 * @Description:
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
                0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
//                    Thread.sleep(1000);
                } finally {
                    System.out.println("thread1");
                    countDownLatch.countDown();
                }
                System.out.println("thread1 ok");
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
//                    Thread.sleep(1000);
                } finally {
                    System.out.println("thread2");
                    countDownLatch.countDown();
                }
                System.out.println("thread2 ok");

            }
        });
        System.out.println("wait all threads over");
        countDownLatch.await();
        System.out.println("all threads over");
        executor.shutdown();
    }
}
