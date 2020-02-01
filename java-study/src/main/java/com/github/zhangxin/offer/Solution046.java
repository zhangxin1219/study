package com.github.zhangxin.offer;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/21 16:30
 * @Description:
 */
public class Solution046 {
    private int sum = 0;
    private int x = 1;

    public int Sum_Solution(int n) {
        //Test test =new Test();

        // java创建数组时并不会给每个元素实例化, 只是初始化了引用空间
        // 剑指offer上的构造函数法, 在java中实现不了
        Test[] test = new Test[n];
        return sum;
    }

    public class Test {
        public Test() {
            sum += x;
            x++;
        }
    }

    @org.junit.Test
    public void test() {
        Solution046 solution046 = new Solution046();
        System.out.println(solution046.Sum_Solution(1));
        int[] a = {1, 5, 3, 2};
        Arrays.sort(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
