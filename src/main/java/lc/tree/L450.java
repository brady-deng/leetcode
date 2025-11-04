package lc.tree;

import lc.common.ob.TreeNode;
import lc.tree.myTest.L450Test;
import lc.util.LUtil;

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
public class L450 {
    public static void main(String[] args) {
        TreeNode head = LUtil.inputTree();
        int key = LUtil.inputNum();
//        System.out.println(new L450().deleteNode(head, key));
        System.out.println(new L450Test().deleteNode(head, key));
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            }
            else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            }
            else {
                if (parent == null) {
                    TreeNode tmpCur = null;
                    if (cur.right != null) {
                        tmpCur = cur.right;
                        while (tmpCur.left != null) {
                            tmpCur = tmpCur.left;
                        }
                        tmpCur.left = cur.left;
                        return cur.right;
                    }
                    else if (cur.left != null) {
                        tmpCur = cur.left;
                        while (tmpCur.right != null) {
                            tmpCur = tmpCur.right;
                        }
                        tmpCur.right = cur.right;
                        return cur.left;
                    }
                    return null;
                }
                else if (parent.right == cur) {
                    if (cur.right != null) {
                        parent.right = cur.right;
                        TreeNode tmpCur = cur.right;
                        while (tmpCur.left != null) {
                            tmpCur = tmpCur.left;
                        }
                        tmpCur.left = cur.left;
                    }
                    else if (cur.left != null) {
                        parent.right = cur.left;
                        TreeNode tmpCur = cur.left;
                        while (tmpCur.right != null) {
                            tmpCur = tmpCur.right;
                        }
                        tmpCur.right = cur.right;
                    }
                    else {
                        parent.right = null;
                    }
                }
                else if (parent.left == cur) {
                    if (cur.right != null) {
                        parent.left = cur.right;
                        TreeNode tmpCur = cur.right;
                        while (tmpCur.left != null) {
                            tmpCur = tmpCur.left;
                        }
                        tmpCur.left = cur.left;
                    }
                    else if (cur.left != null) {
                        parent.left = cur.left;
                        TreeNode tmpCur = cur.left;
                        while (tmpCur.right != null) {
                            tmpCur = tmpCur.right;
                        }
                        tmpCur.right = cur.right;
                    }
                    else {
                        parent.left = null;
                    }
                }
                return root;
            }
        }
        return root;
    }
}
