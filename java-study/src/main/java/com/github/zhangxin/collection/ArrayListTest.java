package com.github.zhangxin.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/30 15:26
 * @Description:
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Integer> l = list.subList(3, 7);
        l.set(1, 100);
        list.forEach(x -> System.out.println(x));
    }
}
