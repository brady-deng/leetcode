package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * </p>
 * <a href=https://leetcode.com/problems/flatten-binary-tree-to-linked-list/>ref</a>
 * <p>
 *     [1,2,5,3,4,null,6] --> [1,null,2,null,3,null,4,null,5,null,6]
 * [] --> []
 * [0] --> [0]
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/21
 **/
public class L114 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String nodes = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(nodes);
        new L114().flatten(head);
        System.out.println(head);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> preOrder = new ArrayList<>();
        preOrder(root, preOrder);
        buildFlat(preOrder);
    }

    public TreeNode buildFlat(List<TreeNode> tmp) {
        if (!tmp.isEmpty()) {
            TreeNode head = tmp.get(0);
            head.left = null;
            TreeNode cur = head;
            for (int i = 1; i < tmp.size(); i++) {
                tmp.get(i).left = null;
                cur.right = tmp.get(i);
                cur.left = null;
                if (i != tmp.size()-1) {
                    cur = cur.right;
                }
            }
            return head;
        }
        else {
            return null;
        }
    }

    public static void preOrder(TreeNode root, List<TreeNode> tmp) {
        if (root != null) {
            tmp.add(root);
            if (root.left != null) {
                preOrder(root.left, tmp);
            }
            if (root.right != null) {
                preOrder(root.right, tmp);
            }
        }
    }
}
