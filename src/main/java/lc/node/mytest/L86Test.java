package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L86;

/**
 * <p>
 *     Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * </p>
 * <a href = https://leetcode.com/problems/partition-list/>ref</a>
 * <p>
 *     [1,4,3,2,5,2] 3 --> [1,2,2,4,3,5]
 *      [2,1] 2 --> [1,2]
 * </p>
 */
public class L86Test extends L86 {


    @Override
    public ListNode partition(ListNode head, int x) {
        ListNode lh = new ListNode();
        ListNode rh = new ListNode();
        ListNode l = lh;
        ListNode r = rh;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                l.next = cur;
                l = cur;
                cur = cur.next;
            } else {
                r.next = cur;
                r = cur;
                cur = cur.next;
            }
        }
        l.next = rh.next;
        r.next = null;
        return lh.next;
    }
}
