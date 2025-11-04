package lc.node;

import lc.common.ob.ListNode;
import lc.node.mytest.L83Test;
import lc.util.LUtil;


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
public class L83 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
        System.out.println(new L83().deleteDuplicates(head));
        System.out.println(new L83Test().deleteDuplicates(head2));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null) {

            ListNode cur = head;
            ListNode preNode = head;
            int depth = 0;
            int prev = -120;
            while (cur != null) {
                if (cur.val != preNode.val) {
                    ListNode tmp = cur.next;
                    preNode.next = cur;
                    preNode = preNode.next;
                    preNode.next = null;
                    prev = cur.val;
                    cur = tmp;
                }
                else {
                    cur = cur.next;
                }
            }
            if (preNode == head) {
                head.next = null;
            }
        }
        return head;
    }
}
