package com.github.zhangxin.leetcode.tree;

import com.github.zhangxin.leetcode.util.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/11 20:29
 * @Description: 二叉树的层次遍历 II
 */
public class Solution0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeNode p = root;
        if (p == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(p);
        ans.add(Arrays.asList(p.val));
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                    levelList.add(temp.left.val);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    levelList.add(temp.right.val);
                }
            }
            if (levelList.size() > 0)
                ans.add(0, levelList);
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(root));
    }
}
