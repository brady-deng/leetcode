package lc.tree.myTest;

import lc.common.ob.ListNode;
import lc.common.ob.TreeNode;
import lc.tree.binarySearchTree.L109;

/**
 * <p>
 *     Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 * </p>
 * <a href=https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/>ref</a>
 * <p>
 *     [-10,-3,0,5,9] --> [0,-3,9,-10,null,5]
 * [] --> []
 * </p>
 * <p>
 *     Medium
 * </p>
 * <p>
 *     A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/20
 **/
public class L109Test extends L109 {

    @Override
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head);
    }

    public TreeNode buildTree(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode mid = new TreeNode(head.val);
            mid.right = new TreeNode(head.next.val);
            return mid;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = new ListNode();
        prev.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = prev.next;
            slow = slow.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        ListNode r = slow.next;
        prev.next = null;
        mid.left = buildTree(head);
        mid.right = buildTree(r);
        return mid;
    }
}
