package com.github.zhangxin.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/30 19:53
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("a", 1);
//        hashMap.put("b", 2);
//        hashMap.forEach((k, v) -> System.out.println(k + " " + v));
//        System.out.println(hashMap.keySet());
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, false);
        for (int i = 0; i < 5; i++) {
            linkedHashMap.put(i+"",i);
        }
        linkedHashMap.get("2");
        linkedHashMap.get("1");
        System.out.println(linkedHashMap);
    }
}
