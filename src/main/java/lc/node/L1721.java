package lc.node;

import lc.common.ob.ListNode;
import lc.node.mytest.L1721Test;
import lc.util.LUtil;

/**
 * <p>
 *     You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 * </p>
 * <a href=https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/>ref</a>
 * <p>
 *     Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * </p>
 * <p>
 *     Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/15
 **/
public class L1721 {

    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
        int k = LUtil.inputNum();
        System.out.println(new L1721().swapNodes(head, k));
        System.out.println(new L1721Test().swapNodes(head2, k));
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head != null) {
            int i = 1;
            int dep = 0;
            ListNode cur = head;
            ListNode posNode = head;

            while (cur != null) {
                dep++;
                if (i == k) {
                    posNode = cur;
                }

                cur = cur.next;
                i++;
            }
            i = 1;
            ListNode negNode = head;

            while (dep-i+1 != k) {
                i++;

                negNode = negNode.next;
            }
            int val = posNode.val;
            posNode.val = negNode.val;
            negNode.val = val;
            return head;
        }
        return head;
    }
}
