package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.node.mytest.L328Test;
import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * </p>
 * <a href=https://leetcode.com/problems/odd-even-linked-list/description/>ref</a>
 * <p>
 *     Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * </p>
 * <p>
 *     Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/14
 **/
public class L328 {
    public static void main(String[] args) {
        ListNode l = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(l);
        System.out.println(new L328().oddEvenList(l));
        System.out.println(new L328Test().oddEvenList(head2));
    }

    public ListNode oddEvenList(ListNode head) {
        if(head != null && head.next != null) {
            ListNode odd = head.next;
            ListNode oddPre = new ListNode(head.next.val);
            ListNode oddHead = oddPre;
            ListNode even = head;
            ListNode evenPre = new ListNode(head.val);
            ListNode evenHead = evenPre;
            while (even != null && even.next != null) {
                even = even.next.next;
                if (even != null) {
                    evenPre.next = new ListNode(even.val);
                    evenPre = evenPre.next;
                }
            }
            while (odd != null && odd.next != null) {
                odd = odd.next.next;
                if (odd != null) {
                    oddPre.next = new ListNode(odd.val);
                    oddPre = oddPre.next;
                }
            }
            evenPre.next = oddHead;
            head = evenHead;
        }
        return head;
    }
}
