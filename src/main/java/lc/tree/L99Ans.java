package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

/**
 * <p>
 *     You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * </p>
 * <a href = https://leetcode.com/problems/recover-binary-search-tree/>ref</a>
 * <p>
 *     [1,3,null,null,2] --> [3,1,null,null,2]
 *     [3,1,4,null,null,2] --> [2,1,4,null,null,3]
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/16
 **/
public class L99Ans {


    /**
     * first, the first mistake node
     * second, the first mistake node
     * prev, the parent node
     */
    TreeNode prev = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        evalSwappedNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    /**
     * the inorder of a valid binary search tree is ascending
     * @param curr
     */
    private void evalSwappedNodes(TreeNode curr) {
        if (curr == null)
            return;
        evalSwappedNodes(curr.left);
        if (prev != null && prev.val > curr.val) {
            if (first == null)
                first = prev;
            second = curr;
        }
        prev = curr;
        evalSwappedNodes(curr.right);
    }
}
