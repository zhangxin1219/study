package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 15:14
 * @Description: 删除排序数组中的重复项
 */
public class Solution0026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length == 1)
            return 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
    }
}
