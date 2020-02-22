package com.github.zhangxin.sort;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/22 20:52
 * @Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 1, 9, 7, 8, 5, 10};
        sort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }

    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for (int l = start; l <= end; l++) {
            array[l] = temp[l-start];
        }
    }
}
