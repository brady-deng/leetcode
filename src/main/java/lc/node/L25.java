package main.java.lc.node;

import main.java.lc.common.ob.ListNode;

import java.util.Scanner;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <a href =https://leetcode.com/problems/reverse-nodes-in-k-group/>refer</a>
 * <p></p>
 * case:[1,2,3,4,5] 2 -- > [2,1,4,3,5]
 * [1,2,3,4,5] 3 -- > [3,2,1,4,5]
 * @author dengchenyang@tju.edu.cn
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
