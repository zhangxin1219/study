package com.github.zhangxin.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/23 15:25
 * @Description:
 */
public class Solution064 {
    public PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public PriorityQueue<Integer> min = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (((min.size() + max.size()) & 1) == 0) {// 偶数
            if (max.size() > 0 && max.element() > num) {
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        } else {// 奇数
            if (min.size() > 0 && min.element() < num) {
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public Double GetMedian() {
        if (min.size() + max.size() <= 0) {
            return null;
        }
        double ans = 0;
        if (((min.size() + max.size()) & 1) == 0) {
            ans = (min.element() + max.element()) / 2;
        } else {
            ans = (double) min.element();
        }
        return ans;
    }

    public static void main(String[] args) {
//        Solution064 solution064 = new Solution064();
//        PriorityQueue<Integer> max = solution064.max;
//        int[] a = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
//        for (int i = 0; i < a.length; i++) {
//            solution064.Insert(a[i]);
//        }
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(solution064.GetMedian());
//        }
        int i = 1;
        int j = 2;
        double x = (double)(i+j)/2;
        System.out.println(x);
    }
}
