package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/30
 **/
public class L124Ans {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // helper returns the max branch
    // plus current node's value
    int helper(TreeNode root) {
        if (root == null) return 0;

        // left refers to the max path of root.left
        int left = Math.max(helper(root.left), 0);
        // rigth refers to the max path of root.right
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        // only root and one of its child node is on the path, not all the right and left
        return root.val + Math.max(left, right);
    }
}
