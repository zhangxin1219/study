package com.github.zhangxin.collection;

import java.util.HashSet;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/30 19:33
 * @Description:
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);
        hashSet.forEach(x -> System.out.println(x));
    }
}
