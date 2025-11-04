package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L450;

/**
 * <p>
 *     Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * </p>
 * <a href=https://leetcode.com/problems/delete-node-in-a-bst/description/>ref</a>
 * <p>
 *     Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 * </p>
 * <p>
 *     Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * </p>
 * <p>
 *     Input: root = [], key = 0
 * Output: []
 * </p>
 * <p>
 *     medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/9
 **/
public class L450Test extends L450 {
    @Override
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.val == key && root.left == null && root.right == null)) {
            return null;
        }
        if (root.val == key) {
            root = swapTreeNode(root);
        }
        if (root.left != null && root.left.val == key) {
            root.left = swapTreeNode(root.left);
        }
        if (root.right != null && root.right.val == key) {
            root.right = swapTreeNode(root.right);
        }
        if (root.val < key) {
            deleteNode(root.right, key);
        } else {
            deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode swapTreeNode(TreeNode p) {
        TreeNode res = p;
        if (p.left == null && p.right == null) {
            return null;
        }
        else if (p.left != null) {
            TreeNode pre = p;
            TreeNode cur = p.left;
            if (cur.right == null) {
                p.val = p.left.val;
                p.left = swapTreeNode(cur);
            } else {
                while (cur.right != null) {
                    pre = cur;
                    cur = cur.right;
                }
                p.val = cur.val;
                pre.right = swapTreeNode(cur);
            }
        }
        else {
            TreeNode pre = p;
            TreeNode cur = p.right;
            if (cur.left == null) {
                p.val = p.right.val;
                p.right = swapTreeNode(cur);
            } else {
                while (cur.left != null) {
                    pre = cur;
                    cur = cur.left;
                }
                p.val = cur.val;
                pre.left = swapTreeNode(cur);
            }
        }
        return res;
    }
}
