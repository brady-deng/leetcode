package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.mytest.L2Test;
import main.java.lc.util.LUtil;

/**
 * <p>
 *     You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * </p>
 * <a href=https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/2
 **/
public class L2 {

    public static void main(String[] args) {
        ListNode l1 = LUtil.inputNodes();
        ListNode l2 = LUtil.inputNodes();
        ListNode res = new L2().addTwoNumbers(l1, l2);
        ListNode res2 = new L2Test().addTwoNumbers(l1, l2);
        LUtil.printNode(res);
        LUtil.printNode(res2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int obmod = 0;
        int temp;
        ListNode head = new ListNode();
        ListNode prev = head;
        ListNode cur = null;
        while(l1 != null && l2 != null){
            temp = (l1.val+l2.val+obmod)>9?(l1.val+l2.val-10+obmod):(l1.val+l2.val+obmod);
            obmod = (l1.val+l2.val+obmod)>9?1:0;
            l1 = l1.next;
            l2 = l2.next;
            cur = new ListNode(temp);
            prev.next = cur;
            prev = cur;
        }
        while (l1 != null){
            temp = (l1.val+obmod)>9?(l1.val+obmod-10):(l1.val+obmod);
            obmod = (l1.val+obmod)>9?1:0;
            l1 = l1.next;
            cur = new ListNode(temp);
            prev.next = cur;
            prev = cur;
        }
        while (l2 != null){
            temp = (l2.val+obmod)>9?(l2.val+obmod-10):(l2.val+obmod);
            obmod = (l2.val+obmod)>9?1:0;
            l2 = l2.next;
            cur = new ListNode(temp);
            prev.next = cur;
            prev = cur;
        }
        if(obmod != 0){
            cur = new ListNode(obmod);
            prev.next = cur;
        }

        return head.next;
    }
}
