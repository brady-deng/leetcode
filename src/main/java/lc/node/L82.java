package main.java.lc.node;

import main.java.lc.common.ob.ListNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * </p>
 * <a href = https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/>ref</a>
 * <p>
 *     [1,2,3,3,4,4,5] --> [[1,2,5]
 * [1,1,1,2,3] --> [2,3]
 * </p>
 */
public class L82 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the cur val:");
            int tmp = scanner.nextInt();
            cur.val = tmp;
            if (i != n-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println(deleteDuplicates(head));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        int prev = -125;
        int depth = 0;
        ListNode cur = head;
        ListNode pre2Node = null;
        boolean flag = false;
        while (cur!= null) {
            if (prev != cur.val) {
                ListNode tmp = cur.next;
                if (null != pre2Node && tmp != null && tmp.val != cur.val) {
                    pre2Node.next = cur;
                }
                if (tmp != null && tmp.val != cur.val) {
                    pre2Node = cur;
                    pre2Node.next = null;
                    if (!flag) {
                        head = pre2Node;
                        flag = true;
                    }
                }
                if (tmp == null && pre2Node == null) {
                    pre2Node = cur;
                    if (!flag) {
                        head = pre2Node;
                        flag = true;
                    }
                }
                else if (pre2Node!= null && tmp == null) {
                    pre2Node.next = cur;
                }
                prev = cur.val;
                cur = tmp;
            }
            else {
                cur = cur.next;
            }
            depth++;
        }
        if (pre2Node!= null || depth == 1) {
            return head;
        }
        else {
            return null;
        }
    }
}
