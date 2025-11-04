package lc.tree.myTest;

import lc.Node;
import lc.tree.L116DFS;

/**
 * <p>
 *     You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 * </p>
 * <a href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node/>ref</a>
 * <p>
 *     [1,2,3,4,5,6,7] --> [1,#,2,3,#,4,5,6,7,#]
 * [] --> []
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class L116Test extends L116DFS {

    @Override
    public Node connect(Node root) {
        recurConnect(root);
        return root;
    }


    public void recurConnect(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        recurConnect(root.left);
        recurConnect(root.right);
    }
}
