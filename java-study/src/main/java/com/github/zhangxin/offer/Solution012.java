package com.github.zhangxin.offer;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/11 10:28
 * @Description:
 */
public class Solution012 {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] ans = new char[n];
        increment(ans,0);
    }

    public void increment(char[] array, int index) {
        if (index == array.length) {
            print(array);
            return;
        }
        for (int i = 0; i < 10; i++) {
            array[index] = (char) ('0' + i);
            increment(array, index + 1);
        }
    }

    public void print(char[] array) {
        boolean isBegin0 = array[0] == '0';
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0' && isBegin0) {
                continue;
            } else {
                isBegin0 = false;
            }

            System.out.print(array[i]);

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution012 solution012 = new Solution012();
        solution012.print1ToMaxOfNDigits(3);
    }
}
