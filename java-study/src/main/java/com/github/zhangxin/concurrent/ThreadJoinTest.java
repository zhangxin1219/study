package com.github.zhangxin.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 14:27
 * @Description:
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date begin = new Date();
        System.out.println(ft.format(begin));
        threadA.start();
        threadA.join();
        Date now = new Date();
        System.out.println(ft.format(now));
    }
}
