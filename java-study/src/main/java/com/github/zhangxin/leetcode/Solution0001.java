package com.github.zhangxin.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 10:10
 * @Description: 两数之和
 */
public class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
