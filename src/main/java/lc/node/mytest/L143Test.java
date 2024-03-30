package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L143;

/**
 * <p>
 *     You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * </p>
 * <a href=https://leetcode.com/problems/reorder-list/>ref</a>
 * <p>
 *     [1,2,3,4] --> [1,4,2,3]
 *     [1,2,3,4,5] --> [1,5,2,4,3]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/23
 **/
public class L143Test extends L143 {
    @Override
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = new ListNode();
        prev.next = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode r = reverseNode(slow);
        ListNode res = mergeNode(head, r);
    }

    public ListNode mergeNode(ListNode l1, ListNode l2) {
        ListNode l = l1;
        ListNode r = l2;
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        while (l != null && r != null) {
            ListNode tl = l.next;
            ListNode tr = r.next;
            prev.next = l;
            l.next = r;
            prev = r;
            l = tl;
            r = tr;
        }
        if (l != null) {
            prev.next = l;
        }
        if (r != null) {
            prev.next = r;
        }
        return newHead.next;
    }

    public ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
