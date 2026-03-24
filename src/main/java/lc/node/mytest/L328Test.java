package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L328;

/**
 * <p>
 *     Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * </p>
 * <a href=https://leetcode.com/problems/odd-even-linked-list/description/>ref</a>
 * <p>
 *     Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * </p>
 * <p>
 *     Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/14
 **/
public class L328Test extends L328 {

    @Override
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prevOdd = new ListNode();
        ListNode prevEven = new ListNode();
        ListNode even = head.next;
        while (cur != null && cur.next != null) {
            prevOdd.next = cur;
            prevEven.next = cur.next;
            prevOdd = prevOdd.next;
            prevEven = prevEven.next;
            cur = cur.next.next;
        }
        if (cur == null) {
            prevOdd.next = even;
        } else {
            prevEven.next = null;
            cur.next = even;
            prevOdd.next = cur;
        }
        return head;
    }
}
