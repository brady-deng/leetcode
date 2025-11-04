package lc.node;

import lc.common.ob.ListNode;
import lc.node.mytest.L21Test;
import lc.util.LUtil;

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
public class L21 {



    public static void main(String[] args) {
        ListNode l1 = LUtil.inputNodes();
        ListNode l2 = LUtil.inputNodes();
        ListNode res = new L21().mergeTwoLists(l1, l2);
        ListNode res2 = new L21Test().mergeTwoLists(l1 ,l2);
        LUtil.printNode(res);
        LUtil.printNode(res2);
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null || list2 != null) {
            ListNode cur = new ListNode();
            ListNode res = new ListNode();
            res.next = cur;
            if (null != list1 && null != list2) {
                while (null != list1 && null != list2) {
                    if (list1.val < list2.val) {
                        cur.val = list1.val;
                        list1 = list1.next;
                    }
                    else {
                        cur.val = list2.val;
                        list2 = list2.next;
                    }
                    if (null != list1 && null != list2) {
                        cur.next = new ListNode();
                        cur = cur.next;
                    }
                }
                if (null != list1) cur.next = list1;
                if (null != list2) cur.next = list2;

            }
            else {
                res.next = list1 == null?list2:list1;
            }
            return res.next;

        }
        else {
            return null;
        }
    }

}
