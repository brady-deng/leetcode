package main.java.lc.node;

import main.java.lc.common.ob.ListNode;

/**
 * <p>
 *     Given the head of a singly linked list, reverse the list, and return the reversed list.
 * </p>
 * <p>
 *     Input: head = [1,2]
 * Output: [2,1]
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/2
 **/
public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }
}
