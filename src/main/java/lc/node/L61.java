package lc.node;

import lc.common.ob.ListNode;
import lc.node.mytest.L61Test;
import lc.util.LUtil;

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
 * <p>
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/8
 **/
public class L61 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        ListNode head2 = LUtil.deepClone(head);
        int k = LUtil.inputNum();
        System.out.println(new L61().rotateRight(head, k));
        System.out.println(new L61Test().rotateRight(head2, k));

    }

    public ListNode rotateRight(ListNode head, int k) {
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
