package com.github.zhangxin.sort;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/21 19:17
 * @Description:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 1, 9, 7, 8, 5, 10};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void sort(int[] array) {
        int len = array.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i+gap; j < len; j += gap) {
                    if (array[j] < array[j - gap]) {
                        int temp = array[j];
                        int k = j - gap;
                        while (k >= 0 && temp < array[k]) {
                            array[k + gap] = array[k];
                            k -= gap;
                        }
                        array[k + gap] = temp;
                    }
                }
            }
        }
    }
}
