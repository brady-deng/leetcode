package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L148;

/**
 * <p>
 *     Given the head of a linked list, return the list after sorting it in ascending order.
 * </p>
 * <a href=https://leetcode.com/problems/sort-list/description/>ref</a>
 * <p>
 *      Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * </p>
 * <p>
 *     Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * </p>
 * <p>
 *     Input: head = []
 * Output: []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/24
 **/
public class L148Test extends L148 {
    @Override
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = new ListNode();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        slow = sortList(slow);
        head = sortList(head);
        return mergeNode(slow, head);
    }

    public ListNode mergeNode(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode prev = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return res.next;
    }


}
