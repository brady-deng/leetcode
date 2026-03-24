package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L203;

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
public class L203Test extends L203 {


    @Override
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        ListNode prev = res;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
            } else {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        return res.next;
    }
}
