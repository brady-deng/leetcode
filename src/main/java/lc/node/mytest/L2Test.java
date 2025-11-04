package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L2;

/**
 *  * <p>
 *  *     You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *  *
 *  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *  * </p>
 *  * <a href=https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 *  * <p>
 *  *     Input: l1 = [2,4,3], l2 = [5,6,4]
 *  * Output: [7,0,8]
 *  * Explanation: 342 + 465 = 807.
 *  * Example 2:
 *  *
 *  * Input: l1 = [0], l2 = [0]
 *  * Output: [0]
 *  * Example 3:
 *  *
 *  * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *  * Output: [8,9,9,9,0,0,0,1]
 *  * </p>
 *  * @author dengchenyang@tju.edu.cn
 *  * @date 2023/12/2
 */
public class L2Test extends L2 {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        int cur = 0;
        ListNode res = new ListNode();
        ListNode prev = res;
        ListNode curNode;
        while (l1 != null && l2 != null) {
            cur = l1.val + l2.val + tmp;
            tmp = cur >= 10? 1: 0;
            cur = cur >= 10? cur-10: cur;
            curNode = new ListNode(cur);
            prev.next = curNode;
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            cur = l1.val + tmp;
            tmp = cur >= 10? 1: 0;
            cur = cur >= 10? cur-10: cur;
            curNode = new ListNode(cur);
            prev.next = curNode;
            prev = prev.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur = l2.val + tmp;
            tmp = cur >= 10? 1: 0;
            cur = cur >= 10? cur-10: cur;
            curNode = new ListNode(cur);
            prev.next = curNode;
            prev = prev.next;
            l2 = l2.next;
        }
        if (tmp == 1) {
            prev.next = new ListNode(1);
        }
        return res.next;
    }
}
