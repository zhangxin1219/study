package com.github.zhangxin.netease;

import com.github.zhangxin.concurrent.CopyOnWriteArrayListTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/12 16:23
 * @Description: 将满二叉树转换为求和树
 */
public class Main0003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] pre = br.readLine().split(" ");
        String[] in = br.readLine().split(" ");
        int[] preOrder = new int[pre.length];
        int[] inOrder = new int[in.length];
        int[] ans = new int[in.length]; // 返回的求和树的中序序列
        for (int i = 0; i < preOrder.length; i++) {
            preOrder[i] = Integer.parseInt(pre[i]);
        }
        for (int i = 0; i < inOrder.length; i++) {
            inOrder[i] = Integer.parseInt(in[i]);
        }
        if (preOrder.length == 0 || inOrder.length == 0 || pre.length != inOrder.length) {
            return;
        }
        convert(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, ans);
        for (int i = 0; i < ans.length - 1; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println(ans[ans.length - 1]);
    }

    public static int convert(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, int[] ans) {
        if (preStart == preEnd && inStart == inEnd) { // 叶子节点
            int result = pre[preStart];
            ans[preStart] = pre.length == 1 ? result : 0;
            return result;
        }
        int root = pre[preStart];
        int i;
        for (i = inStart; i < in.length; i++) {
            if (in[i] == root) {
                break;
            }
        }
        int leftLength = i - inStart;
        int rightLength = inEnd - i;
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftLength - 1;
        int leftInStart = inStart;
        int leftInEnd = i - 1;

        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;
        int rightInStart = i + 1;
        int rightInEnd = inEnd;

        int left = leftLength > 0 ? convert(pre, leftPreStart, leftPreEnd, in, leftInStart, leftInEnd, ans) : 0;
        int right = rightLength > 0 ? convert(pre, rightPreStart, rightPreEnd, in, rightInStart, rightInEnd, ans) : 0;
        ans[i] = left + right;
        return root + left + right;
    }
}
