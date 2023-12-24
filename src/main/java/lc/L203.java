package main.java.lc;

import main.java.lc.common.ob.ListNode;
import main.java.lc.util.LUtil;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/29
 **/
public class L203 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        int n = LUtil.inputNum();
        System.out.println(removeElements(head, n));
    }
    public static ListNode removeElements(ListNode head, int val) {
        if (head != null) {
            ListNode cur = head.next;
            ListNode pre = head;
            while (cur != null) {
                if (pre.val == val && cur.val != val) {
                    head = cur;
                    pre = head;
                    cur = cur.next;
                }
                else if (pre.val == val && cur.val == val) {
                    head = cur.next;
                    pre = head;
                    if (head != null) {
                        cur = cur.next.next;
                    }
                    else {
                        cur = null;
                    }
                }
                else if (pre.val != val && cur.val != val) {
                    pre = pre.next;
                    cur = cur.next;
                }
                else if (pre.val != val && cur.val == val) {
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }
            if (head.val == val) {
                return head.next;
            }

            return head;
        }
        else {
            return head;
        }
    }
}
