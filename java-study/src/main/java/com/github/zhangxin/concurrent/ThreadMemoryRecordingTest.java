package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/14 21:10
 * @Description:
 */
public class ThreadMemoryRecordingTest {
    private static int num = 0;
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready)
                    System.out.println(num + num);
            }
            System.out.println("readThread ……");
        });
        Thread writeThread = new Thread(() -> {
            num = 2;
            ready = true;
            System.out.println("write set over……");
        });
        readThread.start();
        writeThread.start();
        Thread.sleep(1000);
        readThread.interrupt();
        System.out.println("main exit");
    }
}
