package com.github.zhangxin.concurrent;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/21 10:29
 * @Description:
 */
public class AtomicLongTest {
    private static Long atomicLong = 0L;
//        private static AtomicLong atomicLong = new AtomicLong();
    private static Integer[] array1 = {0, 1, 2, 3, 0, 4, 5, 6, 0};
    private static Integer[] array2 = {1, 2, 5, 0, 0, 3, 45, 6, 0};

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (Integer integer : array1) {
                    if (integer == 0) {
//                        atomicLong.incrementAndGet();
                        atomicLong++;
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (Integer integer : array2) {
                    if (integer == 0)
//                        atomicLong.incrementAndGet();
                        atomicLong++;
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicLong);
    }
}
