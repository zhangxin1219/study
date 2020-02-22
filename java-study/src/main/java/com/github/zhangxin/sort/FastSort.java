package com.github.zhangxin.sort;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/22 21:09
 * @Description:
 */
public class FastSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 1, 9, 7, 8, 5, 10};
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int base = array[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && array[j] >= base) {
                j--;
            }
            while (i < j && array[i] <= base) {
                i++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[i];
        array[i]=array[start];
        array[start]=temp;
        sort(array, start, i - 1);
        sort(array, i + 1, end);
    }
}
