package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.util.LUtil;

/**
 * <p>
 *     There is a singly-linked list head and we want to delete a node node in it.
 *
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 *
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 *
 * Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
 *
 * The value of the given node should not exist in the linked list.
 * The number of nodes in the linked list should decrease by one.
 * All the values before node should be in the same order.
 * All the values after node should be in the same order.
 * Custom testing:
 *
 * For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
 * We will build the linked list and pass the node to your function.
 * The output will be the entire list after calling your function.
 * </p>
 * <a href=https://leetcode.com/problems/delete-node-in-a-linked-list/description/>ref</a>
 * <p>
 *     Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * </p>
 * <p>
 *     Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/14
 **/
public class L237 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next == null) {
            node = null;
        }
        else {
            node.val = next.val;
            node.next = next.next;
        }
    }
}
