package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 15:25
 * @Description:
 */
public class ThreadSleepTest {
    private static Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        System.out.println("threadA begin");
                        Thread.sleep(1000);
                        System.out.println("threadA end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        System.out.println("threadB begin");
                        Thread.sleep(1000);
                        System.out.println("threadB end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
