package com.github.zhangxin.leetcode;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 11:07
 * @Description: 两数相加
 */
public class Solution0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = new ListNode(0);
        ListNode r = r1;
        int carry = 0; //进位
        while (true) {
            if (l1 == null && l2 == null && carry == 0) {
                return r;
            }
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            r1.val = carry == 1 ? sum - 10 : sum;
            // 迭代部分
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            if (!(l1 == null && l2 == null && carry == 0)) {
                r1.next = new ListNode(0);
                r1 = r1.next;
            }
        }
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.convertList2ListNode(Arrays.asList(2, 4, 3));
        ListNode l2 = ListNode.convertList2ListNode(Arrays.asList(5, 6, 4));
        System.out.println(addTwoNumbers(l1, l2));
    }
}
