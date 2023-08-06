package main.java.lc;

import main.java.lc.common.ob.ListNode;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/13
 **/
public class L142Test {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        else {
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != null && fast.next != null && fast != slow) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            else {
                return null;
            }
        }
    }
}
