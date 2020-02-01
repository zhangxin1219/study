package com.github.zhangxin.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 10:37
 * @Description:
 */
public class ThreadTest {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello, java");
        }
    }

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread.");
        }
    }

    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello, callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread thread = new MyThread();
//        thread.start();

//        Runnable task = new RunnableTask();
//        new Thread(task).start();
//        new Thread(task).start();

//        FutureTask<String> task = new FutureTask<>(new CallerTask());
//        new Thread(task).start();
//        try{
//            System.out.println(task.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("hi");
            return "hello, java.";
        });
        Thread threadA = new Thread(task);
        threadA.start();
        String result = task.get();
        System.out.println(result);
    }
}
