package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L21;

/**
 * <p>
 *     You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 * </p>
 * <a href=https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/2
 **/
public class L21Test extends L21 {

    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode prev = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                prev = prev.next;
                list1 = list1.next;
            } else {
                prev.next = list2;
                prev = prev.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            prev.next = list1;
        }
        if (list2 != null) {
            prev.next = list2;
        }
        return head.next;
    }
}
