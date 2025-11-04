package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L83;

/**
 * <p>
 *     Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * </p>
 * <a href = https://leetcode.com/problems/remove-duplicates-from-sorted-list/>ref</a>
 * <p>
 *     [1,1,2] --> [1,2]
 * [1,1,2,3,3] --> [1,2,3]
 * </p>
 */
public class L83Test extends L83 {

    @Override
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                cur = cur.next;
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = cur;
        return head;
    }
}
