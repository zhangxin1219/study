package com.github.zhangxin.leetcode.tree;

import com.github.zhangxin.leetcode.util.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/11 13:02
 * @Description:
 */
public class Solution0094 {
    // 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ans.addAll(inorderTraversal1(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal1(root.right));
        return ans;
    }

    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            p = temp.right;
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(root);
        System.out.println(inorderTraversal2(root));
    }
}
