package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.mytest.L445Test;
import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.List;

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
public class L445 {
    public static void main(String[] args) {
        ListNode l1 = LUtil.inputNodes();
        ListNode l2 = LUtil.inputNodes();
        ListNode ll1 = LUtil.deepClone(l1);
        ListNode ll2 = LUtil.deepClone(l2);
        System.out.println(new L445().addTwoNumbers(l1,l2));
        System.out.println(new L445Test().addTwoNumbers(ll1, ll2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = LUtil.reverseNode(l1);
        l2 = LUtil.reverseNode(l2);
        List<ListNode> res = new ArrayList<>();
        int carry = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + carry;
            int val = tmp > 9? tmp - 10: tmp;
            carry = tmp > 9? 1:0;
            ListNode cur = new ListNode(val);
            res.add(cur);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int tmp = l1.val + carry;
            int val = tmp > 9? tmp - 10: tmp;
            carry = tmp > 9? 1:0;
            ListNode cur = new ListNode(val);
            res.add(cur);
            l1 = l1.next;
        }
        while (l2 != null) {
            int tmp = l2.val + carry;
            int val = tmp > 9? tmp - 10: tmp;
            carry = tmp > 9? 1:0;
            ListNode cur = new ListNode(val);
            res.add(cur);
            l2 = l2.next;
        }
        if (carry != 0) {
            res.add(new ListNode(carry));
        }
        for (int i = res.size()-1;i>0;i--) {
            res.get(i).next = res.get(i-1);
        }
        return res.get(res.size()-1);
    }
}
