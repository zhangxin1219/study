package com.github.zhangxin.sort;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/22 20:45
 * @Description:
 */
public class SelectionSort {
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
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
