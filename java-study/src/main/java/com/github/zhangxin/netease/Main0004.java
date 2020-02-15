package com.github.zhangxin.netease;

import java.util.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/14 17:21
 * @Description:
 */
public class Main0004 {
    public static void main(String[] args) {
//        int[] x = {1, 2, 3, 5, 7, 9};
//        System.out.println(Arrays.binarySearch(x, 6));

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; ++i) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        // 按照宽度排序
        Arrays.sort(matrix, (int[] r1, int[] r2)->Integer.compare(r1[0], r2[0]));

        // 求长度数组的最长升序子序列的长度
        List<Integer> subOrder = new ArrayList<>();
        // 先将第0个矩形的长度放入
        subOrder.add(matrix[0][1]);

        // 从第1个开始向后遍历
        for (int i = 1; i < N; ++i) {
            // 若大于等于序列的最后一个，添加在序列尾
            if (matrix[i][1] >= subOrder.get(subOrder.size() - 1)) {
                subOrder.add(matrix[i][1]);
            } else {
                // 否则，在序列中找到此值的插入位置,由于序列是有序的，使用二分查找
                int index = Collections.binarySearch(subOrder, matrix[i][1]);
                if (index >= 0) {
                    // 若找到相等的则跳过
                    continue;
                } else {
                    // 否则将该位置的数替换为此数
                    index = - index - 1;
                    subOrder.set(index, matrix[i][1]);
                }
            }
        }
        subOrder.forEach(x-> System.out.println(x));
        System.out.println(subOrder.size());
    }
}
