package main.java.lc.node.mytest;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.L1721;

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
public class L1721Test extends L1721 {

    @Override
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int l = 0;
        while (cur != null) {
            l++;
            cur = cur.next;
        }
        int i = 0;
        ListNode res = new ListNode();
        ListNode lp = res;
        ListNode rp = lp;
        cur = lp;
        lp.next = head;
        if (l/2 == k && l%2 ==1){
            return head;
        }
        int r = l-k;
        if (r < k) {
            int t = r;
            r = k;
            k = t;
        }
        while (cur != null) {
            if (i == k-1) {
                lp = cur;
            }
            if (i == r) {
                rp = cur;
            }
            i++;
            cur = cur.next;
        }
        ListNode ln = lp.next;
        ListNode rn = rp.next;
        if (ln == rp) {
            lp.next = rn;
            ListNode tmp = rn.next;
            rn.next = ln;
            ln.next = tmp;
        } else {
            ListNode lnext = ln.next;
            ln.next = rn.next;
            rn.next = lnext;
            lp.next = rn;
            rp.next = ln;
        }
        return res.next;
    }
}
