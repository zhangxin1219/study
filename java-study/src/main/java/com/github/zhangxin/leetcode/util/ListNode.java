package com.github.zhangxin.leetcode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 11:05
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        if (this == null)
            return b.append("]").toString();
        ListNode temp = new ListNode(0);
        temp = this;
        int i = 0;
        while (true) {
            b.append(temp.val);
            if (temp.next == null || i > 15) {
                return b.append("]").toString();
            } else {
                b.append(",");
                temp = temp.next;
            }
            i++;
        }
    }

    public static ListNode convertList2ListNode(List<Integer> list) {
        if (list.isEmpty())
            return null;
        ListNode listNode = new ListNode(0);
        ListNode currentNode = listNode;
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            currentNode.val = list.get(i);
            if (i < listSize - 1) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            } else {
                currentNode.next = null;
            }
        }
        return listNode;
    }

    // No.141 构造环形链表
    public static ListNode convertList2ListNode(List<Integer> list, int pos) {
        if (list.isEmpty())
            return null;
        ListNode listNode = new ListNode(0);
        ListNode currentNode = listNode;
        ListNode posNode = null;
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            currentNode.val = list.get(i);
            if (i == pos) {
                posNode = currentNode;
            }
            if (i < listSize - 1) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            } else {
                currentNode.next = posNode;
            }

        }
        return listNode;
    }

    // No.160 构造两条链表相交,l1=list1+list,l2=list2+list
    public static List<ListNode> convertLists2IntersectingListNodes(List<Integer> list1, List<Integer> list2, List<Integer> list) {
        // 链表l1与链表l2相较于list第一个元素，若list第一个元素为空，即不相交
        // 默认l1,l2不为空,若为空不存在交点.
        if (list1 == null || list2 == null) return null;
        int size = list.size();
        ListNode l = size == 0 ? null : new ListNode(0);
        ListNode currentNode = l;
        if (l != null) {
            for (int i = 0; i < size; i++) {
                currentNode.val = list.get(i);
                if (i < size - 1) {
                    currentNode.next = new ListNode(0);
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = null;
                }
            }
        }
        int size1 = list1.size();
        ListNode l1 = new ListNode(0);
        currentNode = l1;
        for (int i = 0; i < size1; i++) {
            currentNode.val = list1.get(i);
            if (i < size1 - 1) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            } else {
                currentNode.next = l;
            }
        }
        int size2 = list2.size();
        ListNode l2 = new ListNode(0);
        currentNode = l2;
        for (int i = 0; i < size2; i++) {
            currentNode.val = list2.get(i);
            if (i < size2 - 1) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            } else {
                currentNode.next = l;
            }
        }
        List<ListNode> ans = new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        return ans;

    }

    // No.160 构造两条链表相交,l1=list1,l2=list1,其中l2是l1的子集
    // e.g.
    // l1: 1->2->3->4->5
    // l2: 4->5
    public static List<ListNode> convertLists2IntersectingListNodes(List<Integer> list1, List<Integer> list2) {
        if (list1.isEmpty() || list2.isEmpty()) return null;
        Integer firstB = list2.get(0);
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode currentNode = headA;
        int listSize = list1.size();
        for (int i = 0; i < listSize; i++) {
            currentNode.val = list1.get(i);
            if (firstB == currentNode.val)
                headB = currentNode;
            if (i < listSize - 1) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            } else {
                currentNode.next = null;
            }

        }
        List<ListNode> ans = new ArrayList<>();
        ans.add(headA);
        ans.add(headB);
        return ans;
    }

    // NO.142 返回节点在链表中所在位置
    public int indexOf(ListNode head) {
        ListNode temp = head;
        int i = 0;
        while (temp.next != null) {
            if (this == temp) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
}
