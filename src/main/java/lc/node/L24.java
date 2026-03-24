package main.java.lc.node;


import main.java.lc.common.ob.ListNode;
import main.java.lc.node.mytest.L24Test;
import main.java.lc.util.LUtil;

/**
 * <b>medium</b><p></p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p></p>
 * refer <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">ref</a>
 * <p>
 * test case:
 * [1,2,3,4]
 * []
 * [1]
 * <p></p>
 * @author dengchenyang@tju.edu.cn
 * @Description
 * @Date 2021/7/4
 **/
public class L24 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
        System.out.println(head);
        System.out.println(new L24().swapNode(head));
        System.out.println(new L24Test().swapNode(head2));
    }

    public ListNode swapNode(ListNode head) {
        ListNode cur = head;
        if (cur != null && cur.next != null) {
            cur = swap2Node(cur, cur.next);
        }
        else if (cur != null) {
            return cur;
        }
        else {
            return null;
        }
        return cur;
    }


    public ListNode swap2Node(ListNode pre, ListNode next) {
        ListNode tmp = null;
        if (null != next.next && null != next.next.next) {
            tmp = swap2Node(next.next, next.next.next);
        }
        else if (null != next.next) {
            tmp = next.next;
        }
        else {
            tmp = null;
        }
        next.next = pre;
        pre.next = tmp;
        return next;
    }
}
