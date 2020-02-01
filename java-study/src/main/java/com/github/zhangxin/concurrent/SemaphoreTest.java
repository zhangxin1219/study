package com.github.zhangxin.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/27 11:21
 * @Description:
 */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.submit(() -> {
            System.out.println("a start");
            semaphore.release();
            System.out.println("a end");
        });
        executor.submit(() -> {
            System.out.println("b start");
            semaphore.release();
            System.out.println("b end");
        });
        semaphore.acquire(2);
        executor.submit(() -> {
            System.out.println("a2 start");
            semaphore.release();
            System.out.println("a2 end");
        });
        executor.submit(() -> {
            System.out.println("b2 start");
            semaphore.release();
            System.out.println("b2 end");
        });
        semaphore.acquire(2);
        System.out.println("over");
        executor.shutdown();
    }
}
