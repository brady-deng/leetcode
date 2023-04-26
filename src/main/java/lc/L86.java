package main.java.lc;

import java.util.Scanner;

public class L86 {
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
        System.out.println("Please input the num target:");
        int tar = scanner.nextInt();
        System.out.println(partition(head, tar));
    }
    public static ListNode partition(ListNode head, int x) {
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
