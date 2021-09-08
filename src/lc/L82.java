package lc;

import java.util.Scanner;

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
//        ListNode validNode = head;
//        int tmp = 0;
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
//                if (depth >=2) {
//                    pre2Node = pre2Node.next;
//                }
            }
            else {
                cur = cur.next;
            }
            depth++;
//            else {
////                tmp++;
//                if (pre2Node == head) {
//                    pre2Node = cur.next;
//                    depth = -1;
//                    head = pre2Node;
//                }
////                else {
////                    flag = true;
////                }
//                cur = cur.next;
//            }
//            depth++;
        }
        if (pre2Node!= null || depth == 1) {
            return head;
        }
        else {
            return null;
        }
    }
}
