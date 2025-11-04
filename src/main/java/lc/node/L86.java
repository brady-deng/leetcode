package lc.node;

import lc.common.ob.ListNode;
import lc.node.mytest.L86Test;
import lc.util.LUtil;


/**
 * <p>
 *     Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * </p>
 * <a href = https://leetcode.com/problems/partition-list/>ref</a>
 * <p>
 *     [1,4,3,2,5,2] 3 --> [1,2,2,4,3,5]
 *      [2,1] 2 --> [1,2]
 * </p>
 */
public class L86 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
        int tar = LUtil.inputNum();
        System.out.println(new L86().partition(head, tar));
        System.out.println(new L86Test().partition(head2, tar));
    }
    public ListNode partition(ListNode head, int x) {
        if (head != null && head.next != null) {

            ListNode cur = head;
//        int depth = 0;
//        List<Integer> lowI = new ArrayList<>();
//        List<Integer> highI = new ArrayList<>();
            ListNode lNode = new ListNode();
            ListNode cl = lNode;
            ListNode pl = lNode;
            ListNode hNode = new ListNode();
            ListNode ch = hNode;
            ListNode ph = hNode;
            int ldp = 0;
            int rdp = 0;
            while (cur != null) {
                if (cur.val >= x) {
                    ch.val = cur.val;
                    if (ch != hNode) {
                        ph = ph.next;
                    }
                    ch.next = new ListNode();
                    ch = ch.next;
                    rdp++;
                }
                else {
                    cl.val = cur.val;
                    if (cl != lNode) {
                        pl = pl.next;
                    }
                    cl.next = new ListNode();
                    cl = cl.next;
                    ldp++;
                }
                cur = cur.next;
//            depth++;
            }
            if (rdp > 0) {
                pl.next = hNode;
            }
            else {
                pl.next = null;
            }
            ph.next = null;
            if (ldp > 0) {
                return lNode;
            }
            else {
                return hNode;
            }
        }
        else {
            return head;
        }
    }
}
