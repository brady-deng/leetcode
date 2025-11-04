package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L24;

/**
 * <b>medium</b><p></p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p></p>
 * refer <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">ref</a>
 * <p>
 * test case:
 * [1,2,3,4]
 * [2,1,4,3]
 * []
 * []
 * [1]
 * [1]
 * <p></p>
 * @author dengchenyang@tju.edu.cn
 * @Description
 * @Date 2021/7/4
 **/
public class L24Test extends L24 {

    @Override
    public ListNode swapNode(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode prev = res;
        ListNode cur = prev.next;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            prev = cur;
            cur = next;
        }
        return res.next;
    }
}
