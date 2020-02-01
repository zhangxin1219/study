package com.github.zhangxin.concurrent;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/24 13:10
 * @Description:
 */
public class ThreadPoolExecutorTest {
    public static class EatTask implements Runnable {
        private String name;

        public EatTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + this.name + " start: " + new Date());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + this.name + " end: " + new Date());
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            Runnable eatTask = new EatTask(" eatTask" + i);
            executor.execute(eatTask);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("finished");
    }
}
