package com.github.zhangxin.concurrent;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/21 13:21
 * @Description:
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("alibaba");
        list.add("huawei");
        list.add("vivo");
        list.add("oppo");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                list.set(0, "baba");
                list.remove(2);
            }
        }
        );

        Iterator<String> iterator = list.iterator();
        thread1.start();
        thread1.join();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
