package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.node.L25;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <a href =https://leetcode.com/problems/reverse-nodes-in-k-group/>refer</a>
 * <p></p>
 * case:[1,2,3,4,5] 2 -- > [2,1,4,3,5]
 * [1,2,3,4,5] 3 -- > [3,2,1,4,5]
 * @author dengchenyang@tju.edu.cn
 * @description Reverse Nodes in k-Group
 * @date 2021/7/4
 **/
public class L25Test extends L25 {

    @Override
    public ListNode swapNode(ListNode head, int k) {
        return swapKNode(head, k);
    }

    public ListNode swapKNode(ListNode head, int k) {
        int i = 0;
        ListNode[] nodes = new ListNode[k];
        ListNode cur = head;
        while (i < k && cur != null) {
            nodes[i] = cur;
            cur = cur.next;
            i++;
        }
        if (i < k) {
            return head;
        }
        ListNode tmp = swapKNode(nodes[nodes.length-1].next, k);
        for (int j = 1; j < k; j++) {
            nodes[j].next = nodes[j-1];
        }
        nodes[0].next = tmp;
        return nodes[nodes.length-1];
    }


}
