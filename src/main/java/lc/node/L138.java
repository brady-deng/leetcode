package lc.node;

import lc.Node;

import java.util.HashMap;

/**
 * <p>
 *     A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * </p>
 * <a href = https://leetcode.com/problems/copy-list-with-random-pointer/description/>ref</a>
 * <p>
 *     [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class L138 {
    public RandomNode copyRandomList(RandomNode head) {
        if (head != null) {

            RandomNode res = new RandomNode(head.val);
            RandomNode tmpRes = res;
            RandomNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
                tmpRes.next = new RandomNode(cur.val);
                tmpRes = tmpRes.next;
            }
            cur = head;
            tmpRes = res;
            while (cur != null) {
                RandomNode tmp = cur.random;
                RandomNode reItem = head;
                RandomNode reItemRes = res;
                if (tmp != null) {
                    while (reItem != null) {
                        if (reItem == tmp) {
                            tmpRes.random = reItemRes;
                        }
                        reItem = reItem.next;
                        reItemRes = reItemRes.next;
                    }
                }
                cur = cur.next;
                tmpRes = tmpRes.next;
            }
            return res;
        }
        else {
            return null;
        }
    }


    public RandomNode copyRandomListAns(RandomNode head) {
        if (head == null) return null;

        HashMap<RandomNode, RandomNode> oldToNew = new HashMap<>();

        RandomNode curr = head;
        while (curr != null) {
            oldToNew.put(curr, new RandomNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }


    public RandomNode copyRandomListAns2(RandomNode head) {
        if (head == null) return null;

        RandomNode curr = head;
        while (curr != null) {
            RandomNode new_node = new RandomNode(curr.val, curr.next);
            curr.next = new_node;
            curr = new_node.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }

        RandomNode old_head = head;
        RandomNode new_head = head.next;
        RandomNode curr_old = old_head;
        RandomNode curr_new = new_head;

        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return new_head;
    }
}
