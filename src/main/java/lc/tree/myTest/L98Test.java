package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L98;

/**
 * <p>
 *     Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * </p>
 * <a href = https://leetcode.com/problems/validate-binary-search-tree/>ref</a>
 * <p>
 *     [2,1,3] --> true
 *      [5,1,4,null,null,3,6] --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/16
 **/
public class L98Test extends L98 {
    @Override
    public boolean isValidBST(TreeNode root) {
        return isValid(root, new long[]{Long.MIN_VALUE, Long.MAX_VALUE});
    }


    public boolean isValid(TreeNode root, long[] thre) {
        if (root == null) {
            return true;
        }
        if (root.val <= thre[0] || root.val >= thre[1]) {
            return false;
        }
        return isValid(root.left, new long[]{thre[0], root.val})
                && isValid(root.right, new long[]{root.val, thre[1]});

    }
}
