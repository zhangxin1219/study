package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 14:27
 * @Description: 合并两个有序链表
 */
public class Solution0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4));
        ListNode l2 = ListNode.convertList2ListNode(Arrays.asList(2, 3, 3));
        System.out.println(mergeTwoLists(l1, l2));
    }
}
