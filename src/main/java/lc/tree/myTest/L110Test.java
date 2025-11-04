package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L110;

/**
 * <p>
 *     Given a binary tree, determine if it is
 * height-balanced
 * .
 * </p>
 * <a href = https://leetcode.com/problems/balanced-binary-tree/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> true
 * [1,2,2,3,3,null,null,4,4] --> false
 * [] --> true
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/26
 **/
public class L110Test extends L110 {

    @Override
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        return Math.abs(l-r) < 2 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int depth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        res = Math.max(l,r) + 1;
        return res;
    }
}
