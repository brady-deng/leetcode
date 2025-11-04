package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L23;

/**
 * <b>hard</b>
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p></p>
 * <p>
 * case: [[1,4,5],[1,3,4],[2,6]]
 * [1,1,2,3,4,4,5,6]
 * </p>
 * <p>
 * []
 * [[]]
 * </p>
 * <p></p>
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">ref</a>
 * <p>
 *     hard
 * </p>
 */
public class L23Test extends L23 {

    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (true) {
            ListNode cur = new ListNode(Integer.MAX_VALUE);
            int c = 0;
            int n = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    c++;
                } else {
                    if (lists[i].val <= cur.val) {
                        cur = lists[i];
                        n = i;
                    }
                }
            }
            if (c == lists.length) {
                break;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                lists[n] = lists[n].next;
            }
        }
        return res.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeNode(lists, 0, lists.length-1);

    }

    public ListNode mergeNode(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start == end-1) {
            return merge2Node(lists[start], lists[end]);
        }
        int mid = start + (end-start)/2;
        ListNode l = mergeNode(lists, start, mid);
        ListNode r = mergeNode(lists, mid+1, end);
        return merge2Node(l, r);
    }

    public ListNode merge2Node(ListNode l, ListNode r) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
                cur = cur.next;
            } else {
                cur.next = r;
                r = r.next;
                cur = cur.next;
            }
        }
        if (l != null) {
            cur.next = l;
        } else {
            cur.next = r;
        }
        return head.next;
    }
}
