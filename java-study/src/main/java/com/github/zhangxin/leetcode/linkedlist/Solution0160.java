package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/4 16:21
 * @Description: 相交链表
 */
public class Solution0160 {
    // 哈希表法,时间复杂度O(m+n),空间复杂度O(m)或O(n)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode pA = headA, pB = headB;
        while (true) {
            if (pA != null) {
                if (!listNodeSet.contains(pA))
                    listNodeSet.add(pA);
                else
                    return pA;
                pA = pA.next;
            }
            if (pB != null) {
                if (!listNodeSet.contains(pB))
                    listNodeSet.add(pB);
                else
                    return pB;
                pB = pB.next;
            }
            if (pA == null && pB == null)
                return null;
        }
    }

    // 双指针法,时间复杂度O(m+n),空间复杂度O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    @Test
    public void test() {
//        List<ListNode> listNodes = ListNode.convertLists2IntersectingListNodes(
//                Arrays.asList(4, 1),
//                Arrays.asList(5, 0, 1),
//                Arrays.asList(8, 4, 5)
//        );
        List<ListNode> listNodes = ListNode.convertLists2IntersectingListNodes(
                Arrays.asList(0, 9, 1, 2, 4),
                Arrays.asList(2)
        );
        ListNode headA = listNodes.get(0);
        ListNode headB = listNodes.get(1);
        System.out.println(getIntersectionNode2(headA, headB));
    }
}
