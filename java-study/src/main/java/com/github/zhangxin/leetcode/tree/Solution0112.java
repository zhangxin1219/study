package com.github.zhangxin.leetcode.tree;

import com.github.zhangxin.leetcode.util.TreeNode;
import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/11 21:07
 * @Description: 路经总和
 */
public class Solution0112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum = sum - root.val;
        if (root.left == null && root.right == null)
            return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root,22));
    }
}
