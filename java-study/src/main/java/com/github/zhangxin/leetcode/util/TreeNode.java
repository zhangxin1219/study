package com.github.zhangxin.leetcode.util;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 21:10
 * @Description:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public String toString() {
        if (this.left == null && this.right != null)
            return this.val + ",null," + this.right.toString();
        if (this.left != null && this.right == null)
            return this.val + "," + this.left.toString() + ",null";
        if (this.left == null && this.right == null)
            return this.val + "";
        return this.val + "," + this.left.toString() + "," + this.right.toString();
    }
}
