package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L445;
import lc.util.LUtil;

/**
 * <p>
 *     You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * </p>
 * <a href=https://leetcode.com/problems/add-two-numbers-ii/description/>ref</a>
 * <p>
 *     Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * </p>
 * <p>
 *     Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * </p>
 * <p>
 *     Input: l1 = [0], l2 = [0]
 * Output: [0]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/27
 **/
public class L445Test extends L445 {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = LUtil.reverseNode(l1);
        l2 = LUtil.reverseNode(l2);
        ListNode res = new ListNode();
        ListNode cur = res;
        int tmp = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + tmp;
            tmp = val >= 10? 1: 0;
            val = val >= 10? val - 10: val;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + tmp;
            tmp = val >= 10? 1: 0;
            val = val >= 10? val-10:val;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + tmp;
            tmp = val >= 10? 1: 0;
            val = val >= 10? val-10:val;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }
        if (tmp == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        res = res.next;
        res = LUtil.reverseNode(res);
        return res;
    }
}
