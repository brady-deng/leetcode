package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L234;
import lc.util.LUtil;

/**
 * <p>
 *     Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 * </p>
 * <a href=https://leetcode.com/problems/palindrome-linked-list/description/>ref</a>
 * <p>
 *     Input: head = [1,2,2,1]
 * Output: true
 * </p>
 * <p>
 *     Input: head = [1,2]
 * Output: false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/14
 **/
public class L234Test extends L234 {


    @Override
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        head = LUtil.reverseNode(head);
        ListNode r = fast == null? slow:slow.next;
        while (head != null && r != null) {
            if (head.val != r.val) {
                return false;
            }
            head = head.next;
            r = r.next;
        }
        return head == r && head == null;
    }


}
