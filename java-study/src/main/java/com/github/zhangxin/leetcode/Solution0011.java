package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 10:07
 * @Description: 盛最多水的容器
 */
public class Solution0011 {
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1;
        int area = 0;
        while (i < j) {
            int deltaHeight = height[i] - height[j];
            if (deltaHeight > 0) {
                area = Math.max(area, (j - i) * height[j]);
                j--;
            } else {
                area = Math.max(area, (j - i) * height[i]);
                i++;
            }
        }
        return area;
    }

    @Test
    public void test() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
