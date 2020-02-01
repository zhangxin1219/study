package com.github.zhangxin.concurrent;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/19 16:16
 * @Description:
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(50));
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(10));
        AtomicLong atomicLong = new AtomicLong();
    }
}
