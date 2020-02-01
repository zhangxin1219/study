package com.github.zhangxin.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 19:22
 * @Description:
 */
public class ThreadInterruptTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    if (Thread.currentThread().isInterrupted())
                        break;
                }
                System.out.println("threadA " + Thread.interrupted());//如果为true, 会清楚中断标志位
                System.out.println("threadA " + Thread.interrupted());
            }
        });
        threadA.start();
        threadA.interrupt();
        threadA.join();
        System.out.println("end");
    }
}
