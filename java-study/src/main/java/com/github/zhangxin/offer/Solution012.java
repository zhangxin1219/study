package com.github.zhangxin.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/11 10:28
 * @Description:
 */
public class Solution012 {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        int[] ans = new int[n];
        //System.out.println(ans[0]);
        increment(ans, 0);
    }

    public void increment(int[] array, int index) {
        if (index == array.length) {
            print(array);
            return;
        }
        for (int i = 0; i < 10; i++) {
            array[index] = 0 + i;
            increment(array, index + 1);
        }
    }

    public void print(int[] array) {
//        System.out.println(array);
        boolean isBeginning0 = true;
        for (int i = 0; i < array.length; i++) {
            if (isBeginning0 && array[i] != 0)
                isBeginning0 = false;
            if (!isBeginning0) {
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }

    @Test
    public void test() {
        Solution012 solution012 = new Solution012();
        solution012.print1ToMaxOfNDigits(3);
    }
}
