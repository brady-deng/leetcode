package main.java.lc.node;

import main.java.lc.common.ob.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * <p>
 *     Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * </p>
 * <a href = https://leetcode.com/problems/reverse-linked-list-ii/>ref</a>
 * <p>
 *     [1,2,3,4,5] 2 4 --> [1,4,3,2,5]
 *      [5] 1 1 --> [5]
 * </p>
 */
public class L92 {
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
        System.out.println("Please input the num left:");
        int l = scanner.nextInt();
        System.out.println("Please input the num right:");
        int r = scanner.nextInt();
//        System.out.println(reverseBetween(head, l, r));
        System.out.println(reverseBetween2(head, l, r));

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int depth = 0;
        ListNode lPre = null;
        ListNode rNext = null;
        ListNode cur = head;
        List<ListNode> tar = new ArrayList<>();
        while (cur != null) {
            if (depth+2 == left) {
                lPre = cur;
            }
            else if (depth == right) {
                rNext = cur;
            }
            else if (depth >= left-1 && depth < right) {
                tar.add(cur);
            }
            depth++;
            cur = cur.next;
        }
        for (int i = tar.size()-1; i>0; i--) {
            tar.get(i).next = tar.get(i-1);
        }
        if (rNext != null) {
            tar.get(0).next = rNext;
        }
        else {
            tar.get(0).next = null;
        }
        if (lPre != null) {
            lPre.next = tar.get(tar.size()-1);
            return head;
        }
        return tar.get(tar.size()-1);

    }


    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        int depth = 0;
        ListNode lPre = null;
        ListNode rNext = null;
        ListNode start = null;
        ListNode end = null;
        ListNode cur = head;
        while (cur != null) {
            if (depth+2 == left) {
                lPre = cur;
            }
            else if (depth == right) {
                rNext = cur;
            }
            if (depth == left-1) {
                start = cur;
            }
            if (depth == right-1) {
                end = cur;
            }
            depth++;
            cur = cur.next;
        }

        ListNode midCur = start.next;
        start.next = rNext;
        ListNode midPre = start;
        while (midCur != rNext) {
            ListNode midNext = midCur.next;
            midCur.next = midPre;
            midPre = midCur;
            midCur = midNext;
        }
//        start.next = rNext;
        if (lPre != null) {
            lPre.next = end;
            return head;
        }
        return end;

    }
}
