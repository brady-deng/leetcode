package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L61;

/**
 * <p>
 *     Given the head of a linked list, rotate the list to the right by k places.
 * </p>
 * <a href = https://leetcode.com/problems/rotate-list/submissions/519293943/>ref</a>
 * <p>
 *     [1,2,3,4,5]
 * 2
 * [4,5,1,2,3]
 *
 * [0,1,2]
 * 4
 * [2,0,1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/8
 **/
public class L61Test extends L61 {

    @Override
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int l = 1;
        ListNode cur = head;
        while (cur.next != null) {
            l++;
            cur = cur.next;
        }
        int reminder = k%l;
        if (reminder == 0 || head  == null) {
            return head;
        }
        int depth = l - reminder;
        ListNode end = cur;
        cur = head;
        ListNode prev = cur;
        int i = 0;
        while (i < depth) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        end.next = head;
        prev.next = null;
        return cur;
    }
}
