package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 13:02
 * @Description: 寻找两个有序数组的中位数
 */
public class Solution0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2, right = (len1 + len2 + 2) / 2;
        return (getKthMin(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKthMin(nums2, 0, len2 - 1, nums1, 0, len1 - 1, right)) / 2;
    }

    private double getKthMin(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKthMin(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1, j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKthMin(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return getKthMin(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
