package main.java.lc;

import main.java.lc.common.ob.ListNode;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/14
 **/
public class L328 {
    public static void main(String[] args) {
        ListNode l = LUtil.inputNodes();
        System.out.println(oddEvenList(l));
    }

    public static ListNode oddEvenList(ListNode head) {
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
