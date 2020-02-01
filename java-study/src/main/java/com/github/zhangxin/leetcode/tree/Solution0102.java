package com.github.zhangxin.leetcode.tree;

import com.github.zhangxin.leetcode.util.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/11 13:50
 * @Description: 二叉树的层次遍历
 */
public class Solution0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        if (p == null)
            return ans;
        queue.add(p);
        ans.add(Arrays.asList(p.val));
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int length = queue.size();
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
                ans.add(levelList);
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
        System.out.println(levelOrder(root));
    }
}
