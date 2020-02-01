package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 18:28
 * @Description:
 */
public class ThreadYieldTest {
    public static class YieldTest implements Runnable {
        public YieldTest() {
            Thread t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (i % 5 == 0) {
                    System.out.println(Thread.currentThread() + "yield cpu.");
                    Thread.yield();
                }
            }
            System.out.println(Thread.currentThread() + "is over");
        }
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
