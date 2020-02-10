package com.github.zhangxin.mianjing;

import java.util.HashMap;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/10 13:47
 * @Description:
 */
public class Solution0001 {
    public static void main(String[] args) {
        HashMap<Short, String> map = new HashMap<>();
        for (Short i = 0; i < 100; i++) {
            map.put(i, String.valueOf(i));
            map.remove((i - 1));// 可以命中桶，但是比较key的时候不会成功, 类型不一样equals方法返回false
            map.remove((short) (i - 1));

        }
        System.out.println(map.size());
        Integer i = 10;
        Short s = 10;
//        s.equals(1000);
        System.out.println(equals(i, s));
//        System.out.println(s==i);
//        System.out.println(hash(10));
    }

    public static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static boolean equals(Object o1, Short o2) {
        if (o1 == o2) {
            return true;
        }
        if (o2 != null && o2.equals(o1)) {
            return true;
        }
        return false;
    }
}
