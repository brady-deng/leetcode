package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.mytest.L143Test;
import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * </p>
 * <a href=https://leetcode.com/problems/reorder-list/>ref</a>
 * <p>
 *     [1,2,3,4] --> [1,4,2,3]
 *     [1,2,3,4,5] --> [1,5,2,4,3]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/23
 **/
public class L143 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = ListNode.deserialize(nums);
        ListNode head2 = LUtil.deepClone(head);
        new L143().reorderList(head);
        new L143Test().reorderList(head2);
        System.out.println(head);
        System.out.println(head2);

    }
    public void reorderList(ListNode head) {
        List<ListNode> tmp = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            tmp.add(cur);
            cur = cur.next;
        }
        reorder(tmp, 0, tmp.size()-1, null);

    }
    public static void reorder(List<ListNode> tmp, int start, int end, ListNode pre) {
        if (start == end) {
            if (pre != null) {
                pre.next = tmp.get(start);
                tmp.get(start).next = null;
            }
        }
        else if (start > end) {
            pre.next = null;
            return;
        }
        else {
            if (pre != null) {
                pre.next = tmp.get(start);
            }
            tmp.get(start).next = tmp.get(end);
            pre = tmp.get(end);
            reorder(tmp, start+1, end-1, pre);
        }
    }
}
