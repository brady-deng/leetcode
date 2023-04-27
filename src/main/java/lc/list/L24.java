package main.java.lc.list;


import main.java.lc.common.ob.ListNode;

import java.util.Scanner;

/**
 * <b>medium</b><p></p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p></p>
 * refer <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">...</a>
 * <p>
 * test case:
 * [1,2,3,4]
 * []
 * [1]
 * <p></p>
 * @author dengchenyang.brady@bytedance.com
 * @Description
 * @Date 2021/7/4
 **/
public class L24 {
    public static void main(String[] args) {
        System.out.println("Please input the num of nodes:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = null;
        ListNode cur = new ListNode();
        if (n > 0) {
            head = new ListNode();
            cur = head;
        }
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the node val");
            int tmp = scanner.nextInt();
            cur.val = tmp;
            if (i != n-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println(head);
        System.out.println(swapNode(head));
    }

    public static ListNode swapNode(ListNode head) {
        ListNode cur = head;
        if (cur != null && cur.next != null) {
            cur = swap2Node(cur, cur.next);
        }
        else if (cur != null) {
            return cur;
        }
        else {
            return null;
        }
        return cur;
    }


    public static ListNode swap2Node(ListNode pre, ListNode next) {
        ListNode tmp = null;
        if (null != next.next && null != next.next.next) {
            tmp = swap2Node(next.next, next.next.next);
        }
        else if (null != next.next) {
            tmp = next.next;
        }
        else {
            tmp = null;
        }
        next.next = pre;
        pre.next = tmp;
        return next;
    }
}
