package com.github.zhangxin.offer;

import java.util.ArrayList;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/3 13:19
 * @Description:
 */
public class Solution005 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null) {
            return ans;
        }
        printListFromTailToHead(listNode, ans);
        return ans;

    }

    public void printListFromTailToHead(ListNode listNode, ArrayList<Integer> arrayList) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next, arrayList);
            arrayList.add(listNode.val);
        }
    }

    public static void main(String[] args) {
        Solution005 solution005 = new Solution005();
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(solution005.printListFromTailToHead(listNode));
    }
}