package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L235;

/**
 * <p>
 *     Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * </p>
 * <a href=https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/>ref</a>
 * <p>
 *     Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * </p>
 * <p>
 *     Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * </p>
 * <p>
 *     Input: root = [2,1], p = 2, q = 1
 * Output: 2
 * </p>
 * <p>
 *     medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/9
 **/
public class L235Test extends L235 {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        return isSubNode(root, p, q);
    }

    public TreeNode isSubNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val) {
            return isSubNode(root.right, p, q);
        }
        if (root.val > q.val) {
            return isSubNode(root.left, p, q);
        }
        return root;
    }
}
