package com.github.zhangxin.sort;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/21 19:42
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 1, 9, 7, 8, 5, 10};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                int j = i - 1;
                while (j >= 0 && temp < array[j]) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }
}
