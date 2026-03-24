package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L82;

/**
 * <p>
 *     Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * </p>
 * <a href = https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/>ref</a>
 * <p>
 *     [1,2,3,3,4,4,5] --> [[1,2,5]
 * [1,1,1,2,3] --> [2,3]
 * </p>
 */
public class L82Test extends L82 {

    @Override
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = head;
        ListNode prev = res;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
        }
        prev.next = cur;
        return res.next;
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode();
        ListNode cur = head;
        ListNode pre = res;
        int tmp = cur.val;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                tmp = cur.val;
                while (cur != null && cur.val == tmp) {
                    cur = cur.next;
                }
            } else {
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
            }
        }
        pre.next = cur;
        return res.next;
    }
}
