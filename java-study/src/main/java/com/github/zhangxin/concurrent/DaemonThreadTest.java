package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 20:42
 * @Description:
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){}
            }
        });
//        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
