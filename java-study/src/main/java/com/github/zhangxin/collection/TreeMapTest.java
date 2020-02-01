package com.github.zhangxin.collection;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/31 16:43
 * @Description:
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(3, 30);
        treeMap.put(1, 10);
        treeMap.put(2, 20);
        System.out.println(treeMap);
    }
}
