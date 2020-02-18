package com.github.zhangxin.concurrent;

import java.util.Collections;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/16 11:32
 * @Description:
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a");
                LockSupport.park();
                System.out.println("b");
                LockSupport.park();
                System.out.println("c");
            }
        });
//        LockSupport.unpark(thread);
//        Thread.sleep(1000);
        thread.start();
        LockSupport.unpark(thread);
    }
}
