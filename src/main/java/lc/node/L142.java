package lc.node;

import lc.common.ob.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 * </p>
 * <a href = https://leetcode.com/problems/linked-list-cycle-ii/>ref</a>
 * <p>
 *     [3,2,0,-4]
 * 1
 * [1,2]
 * 0
 * [1]
 * -1
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/23
 **/
public class L142 {
    public static Map<Integer, Integer> map = new HashMap<>();
    public ListNode detectCycle(ListNode head) {
        while (head != null) {
            int tmp = map.getOrDefault(head.hashCode(), 0);
            if (tmp == 1) {
                return head;
            }
            map.put(head.hashCode(), 1);
            head = head.next;
        }
        return null;
    }
}
