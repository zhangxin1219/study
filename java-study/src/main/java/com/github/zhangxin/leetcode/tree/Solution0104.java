package com.github.zhangxin.leetcode.tree;

import com.github.zhangxin.leetcode.util.TreeNode;
import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/11 15:01
 * @Description: 二叉树的最大深度
 */
public class Solution0104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }
}
