package lc.tree;

import lc.common.ob.TreeNode;
import lc.tree.myTest.L236Test;
import lc.util.LUtil;

import java.util.List;

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
public class L236 {
    public static void main(String[] args) {
        TreeNode head = LUtil.inputTree();
        TreeNode p = LUtil.inputTree();
        TreeNode q = LUtil.inputTree();
        System.out.println(new L236Ans().lowestCommonAncestor(head, p, q).val);
        System.out.println(new L236Test().lowestCommonAncestor(head, p, q).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        List<Integer> vals = TreeNode.inorderTraversal(root);
        while (cur != null) {
            List<Integer> left = vals.subList(0, vals.indexOf(cur.val)+1);
            List<Integer> right = vals.subList(vals.indexOf(cur.val), vals.size());
            if ((left.contains(p.val) && right.contains(q.val)) || (left.contains(q.val) && right.contains(p.val))) {
                return cur;
            }
            else if (left.contains(p.val) && left.contains(q.val)) {
                vals = left;
                cur = cur.left;
            }
            else {
                vals = right;
                cur = cur.right;
            }
        }
        return cur;
    }

}
