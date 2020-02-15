package com.github.zhangxin.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/15 14:52
 * @Description: 每k个反转一次链表
 */
public class Main_翻转链表_从头每k个一次 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public String toString(){
            return val+" ";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
        int k = Integer.parseInt(bf.readLine());
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 0; i < strings.length; i++) {
            ListNode temp = new ListNode(Integer.parseInt(strings[i]));
            tail.next = temp;
            tail = tail.next;
        }
        head = head.next;

        ListNode node = reverse(head, k);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode currentFirst = null;
        ListNode node = head;
        for (int i = 1; i < k; i++) {
            currentFirst = node.next;
            if (currentFirst == null) {
                return head;
            }
            node=node.next;
        }
        ListNode nextHead = currentFirst.next;
        reverseK(head, currentFirst);
        head.next = reverse(nextHead, k);
        return currentFirst;
    }

    public static void reverseK(ListNode start, ListNode end) {
        ListNode pre = null, next = null;
        ListNode node = start;
        while (pre != end) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
//        return start;
    }
}
