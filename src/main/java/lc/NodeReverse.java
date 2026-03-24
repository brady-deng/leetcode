package main.java.lc;

import main.java.lc.common.ob.ListNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/27
 **/
public class NodeReverse {
    public static void main(String[] args) {
        System.out.println("Please input the string s:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = ListNode.deserialize(nums);
        System.out.println(reverseNode(head));
    }

    public static ListNode reverseNode(ListNode head) {
        if (head != null) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = head.next;
            while (cur.next != null) {
                cur.next = pre;
                pre = cur;
                cur = next;
                next = next.next;
            }
            cur.next = pre;
            return cur;
        }
        return head;
    }
}
