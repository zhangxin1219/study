package com.github.zhangxin.leetcode.tree;

import com.github.zhangxin.leetcode.util.TreeNode;
import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/11 20:52
 * @Description: 左叶子之和
 */
public class Solution0404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val+sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
}
