package lc.node;

import lc.common.ob.ListNode;
import lc.node.mytest.L203Test;
import lc.util.LUtil;

/**
 * <p>
 *     Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * </p>
 * <a href=https://leetcode.com/problems/remove-linked-list-elements/description/>ref</a>
 * <p>
 *     Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * </p>
 * <p>
 *Input: head = [], val = 1
 * Output: []
 * </p>
 * <p>
 *     Input: head = [7,7,7,7], val = 7
 * Output: []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/29
 **/
public class L203 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
        int n = LUtil.inputNum();
//        System.out.println(new L203().removeElements(head, n));
        System.out.println(new L203Test().removeElements(head2, n));
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head != null) {
            ListNode cur = head.next;
            ListNode pre = head;
            while (cur != null) {
                if (pre.val == val && cur.val != val) {
                    head = cur;
                    pre = head;
                    cur = cur.next;
                }
                else if (pre.val == val && cur.val == val) {
                    head = cur.next;
                    pre = head;
                    if (head != null) {
                        cur = cur.next.next;
                    }
                    else {
                        cur = null;
                    }
                }
                else if (pre.val != val && cur.val != val) {
                    pre = pre.next;
                    cur = cur.next;
                }
                else if (pre.val != val && cur.val == val) {
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }
            if (head.val == val) {
                return head.next;
            }

            return head;
        }
        else {
            return head;
        }
    }
}
