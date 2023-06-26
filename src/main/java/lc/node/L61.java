package main.java.lc.node;

import main.java.lc.common.ob.ListNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the head of a linked list, rotate the list to the right by k places.
 * </p>
 * <a href = https://leetcode.com/problems/rotate-list/submissions/519293943/>ref</a>
 * <p>
 *     [1,2,3,4,5]
 * 2
 * [4,5,1,2,3]
 *
 * [0,1,2]
 * 4
 * [2,0,1]
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/8
 **/
public class L61 {
    public static void main(String[] args) {
        System.out.println("Please input the k:");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println("Please input the n:");
        int n = scanner.nextInt();
        scanner.nextLine();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i< n; i++) {
            System.out.println("Please input the val:");
            int val = scanner.nextInt();
            cur.val = val;
            if (i != n-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println(rotateRight(head, k));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head != null) {

            int l = 0;
            ListNode cur = head;
            while (cur.next != null) {
                l+=1;
                cur = cur.next;
            }
            if (k % (l+1) == 0) return head;
            else {
                int rem = ((l+1)*(k/(l+1)+1)-k) % (l+1);
                cur = head;
                int i = 1;
                while (i < rem) {
                    cur = cur.next;
                    i++;
                }
                ListNode tmp = cur.next;
                ListNode res = tmp;
                cur.next = null;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = head;
                return res;
            }
        }
        else return null;
    }
}
