package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 15:25
 * @Description:
 */
public class ThreadSleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA begin");
                    Thread.sleep(10000);
                    System.out.println("threadA end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(2000);
        threadA.interrupt();
    }
}
