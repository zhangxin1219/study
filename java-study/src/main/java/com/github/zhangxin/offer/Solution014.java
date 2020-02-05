package com.github.zhangxin.offer;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/3 18:51
 * @Description:
 */
public class Solution014 {
    public void reOrderArray(int[] array) {
//        if (array == null || array.length <= 1) {
//            return;
//        }
//        int k = 0;
//        for (int i = 0; i < array.length; i++) {
//            if ((array[i] & 1) == 1) {
//                int j = i;
//                while (j > k) {
//                    int temp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = temp;
//                    j--;
//                }
//                k++;
//            }
//        }
        int[] newArray = new int[array.length];
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                newArray[j++] = array[i];
            } else {
                newArray[oddCount++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 2, 6, 7, 8};
        Solution014 solution014 = new Solution014();
        solution014.reOrderArray(a);
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
