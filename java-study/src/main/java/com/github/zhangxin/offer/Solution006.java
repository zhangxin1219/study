package com.github.zhangxin.offer;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/3 11:37
 * @Description:
 */


public class Solution006 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0 || pre.length != in.length) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        TreeNode root = new TreeNode(pre[startPre]);
        int rootIn = startIn;
        while (in[rootIn] != pre[startPre]) {
            rootIn++;
        }
        int leftLen = rootIn - startIn;
        int rightLen = endIn - rootIn;
        if (leftLen > 0) {
            root.left = reConstructBinaryTree(pre, startPre + 1, startPre + leftLen, in, startIn, startIn + leftLen - 1);
        }
        if (rightLen > 0) {
            root.right = reConstructBinaryTree(pre, endPre - rightLen + 1, endPre, in, endIn - rightLen + 1, endIn);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution006 solution006 = new Solution006();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(solution006.reConstructBinaryTree(pre, in));
    }

//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        if (pre == null || in == null)
//            return null;
//        TreeNode root = new TreeNode(pre[0]);
//        int x = 0;
//        for (int i = 0; i < in.length; i++) {
//            if (in[i] == root.val) {
//                x = i;
//                break;
//            }
//        }
//        int[] leftIn = Arrays.copyOfRange(in, 0, x);
//        int[] rightIn = Arrays.copyOfRange(in, x + 1, in.length);
//        int[] leftPre = Arrays.copyOfRange(pre, 1, x + 1);
//        int[] rightPre = Arrays.copyOfRange(pre, x + 1, pre.length);
//        if (leftIn.length > 0) {
//            root.left = reConstructBinaryTree(leftPre, leftIn);
//        }
//        if (rightIn.length > 0) {
//            root.right = reConstructBinaryTree(rightPre, rightIn);
//        }
//        return root;
//    }
}
