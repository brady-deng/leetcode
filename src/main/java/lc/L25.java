package main.java.lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @description Reverse Nodes in k-Group
 * @date 2021/7/4
 **/
public class L25 {
    public static void main(String[] args) {
        System.out.println("Please input the num of nodes:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = null;
        ListNode cur = new ListNode();
        if (n > 0) {
            head = new ListNode();
            cur = head;
        }
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the node val");
            int tmp = scanner.nextInt();
            cur.val = tmp;
            if (i != n-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println("Please input the num k:");
        int k = scanner.nextInt();
        System.out.println(head);
        System.out.println(swapNode(head, k));
    }


    public static ListNode swapNode(ListNode head, int k) {
        ListNode cur = head;
        if (cur != null) {
            cur = swapKNode(cur, k);
        }
        else {
            return null;
        }
        return cur;
    }


    public static ListNode swapKNode(ListNode head, int k) {
        ListNode tmp = null;
        ListNode[] thisList = new ListNode[k];
        int i = 0;
        while (null != head && i<k) {
            thisList[i] = head;
            i++;
            head = head.next;
        }
        if (i < k) return thisList[0];
        else {
            tmp = swapKNode(thisList[thisList.length-1].next, k);
        }
        for (int j = k-1;j>0;j--) {
            thisList[j].next = thisList[j-1];
        }
        thisList[0].next = tmp;
        return thisList[thisList.length-1];
    }
}
