package com.github.zhangxin.concurrent;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/17 14:44
 * @Description:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            map.put(1, "-1");
            map.put(5,"5");
        }
        map.forEach((x,y) -> System.out.println(x+" " +y));
    }
}
