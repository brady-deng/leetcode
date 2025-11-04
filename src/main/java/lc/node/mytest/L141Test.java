package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L141;

/**
 * <p>
 *     Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * </p>
 * <a href = https://leetcode.com/problems/linked-list-cycle/>ref</a>
 * <p>
 *     [3,2,0,-4]
 * 1 --> true
 * [1,2]
 * 0 --> true
 * [1]
 * -1 --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/27
 **/
public class L141Test extends L141 {

    @Override
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
