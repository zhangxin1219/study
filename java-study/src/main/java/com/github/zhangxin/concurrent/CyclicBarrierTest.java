package com.github.zhangxin.concurrent;

import java.util.concurrent.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/27 10:14
 * @Description:
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.submit(() -> {
            try {
                System.out.println("thread1 1");
                cyclicBarrier.await();
                System.out.println("thread1 2");
                cyclicBarrier.await();
                System.out.println("thread1 3");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                System.out.println("thread2 1");
                cyclicBarrier.await();
                System.out.println("thread2 2");
                cyclicBarrier.await();
                System.out.println("thread2 3");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }
}
