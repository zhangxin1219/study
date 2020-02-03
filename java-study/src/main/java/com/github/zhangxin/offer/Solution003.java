package com.github.zhangxin.offer;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/3 11:17
 * @Description:
 */
public class Solution003 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Solution003 solution003 = new Solution003();
        boolean ans = solution003.Find(7, array);
        System.out.println(ans);
    }
}
