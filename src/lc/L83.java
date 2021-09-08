package lc;

import java.util.Scanner;

public class L83 {
    public static void main(String[] args) {
        System.out.println("Please input the num of nodes:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the num:");
            cur.val = scanner.nextInt();
            if (i != n-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println(deleteDuplicates(head));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {

            ListNode cur = head;
            ListNode preNode = head;
            int depth = 0;
            int prev = -120;
            while (cur != null) {
                if (cur.val != preNode.val) {
                    ListNode tmp = cur.next;
                    preNode.next = cur;
                    preNode = preNode.next;
                    preNode.next = null;
                    prev = cur.val;
                    cur = tmp;
                }
                else {
                    cur = cur.next;
                }
            }
            if (preNode == head) {
                head.next = null;
            }
        }
        return head;
    }
}
