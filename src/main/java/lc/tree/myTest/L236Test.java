package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L236;


/**
 * <p>
 *     Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * </p>
 * <a href=https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/>ref</a>
 * <p>
 *     Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * </p>
 * <p>
 *     Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * </p>
 * <p>
 *     Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * </p>
 * <p>
 *     medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/9
 **/
public class L236Test extends L236 {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p, q);
    }

    public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode n1 = findAncestor(root.left, p, q);
        if (n1 == null) {
            n1 = findAncestor(root.right, p, q);
        }
        if (n1 != null) {
            return n1;
        }
        else if (isSubTree(root, p) && isSubTree(root, q)) {
            return root;
        }
        return null;
    }

    public boolean isSubTree(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return isSubTree(root.left, p) || isSubTree(root.right, p);
    }
}
