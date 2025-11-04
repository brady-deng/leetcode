package lc.node;

import lc.common.ob.ListNode;

import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230630
 **/
public class ReverseNode {
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
        System.out.println(reverseNode(head));
    }

    public static ListNode reverseNode(ListNode node) {
        ListNode head = node;
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
