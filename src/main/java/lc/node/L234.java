package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.mytest.L234Test;
import main.java.lc.util.LUtil;

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
public class L234 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
//        System.out.println(new L234().isPalindrome(head));
        System.out.println(new L234Test().isPalindrome(head2));
    }


    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow;
        slow = slow.next;
        pre.next = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        slow = pre;
        fast = head;
        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
