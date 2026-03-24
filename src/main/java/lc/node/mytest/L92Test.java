package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L92;

/**
 * <p>
 *     Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * </p>
 * <a href = https://leetcode.com/problems/reverse-linked-list-ii/>ref</a>
 * <p>
 *     [1,2,3,4,5] 2 4 --> [1,4,3,2,5]
 *      [5] 1 1 --> [5]
 * </p>
 * <p>
 *     1 <= left <= right <= n
 * </p>
 */
public class L92Test extends L92 {


    @Override
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        ListNode ol, il, ir, or;
        int i = 1;
        while (i < left) {
            i++;
            cur = cur.next;
        }
        ol = cur;
        il = cur.next;
        cur = il;
        ListNode prev = ol;
        while (i <= right) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            i++;
        }
        ir = prev;
        or = cur;
        ol.next = ir;
        il.next = or;
        return res.next;
    }
}
