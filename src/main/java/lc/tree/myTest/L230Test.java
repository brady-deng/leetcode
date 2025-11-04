package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L230;

/**
 * <p>
 *     Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * </p>
 * <a href=https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/>ref</a>
 * <p>
 *     Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * </p>
 * <p>
 *     Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * </p>
 * <p>
 *     medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/23
 **/
public class L230Test extends L230 {

    @Override
    public int kthSmallest(TreeNode root, int k) {
        int[] c = new int[2];
        inorderK(root, k, c);
        return c[1];
    }

    public void inorderK(TreeNode root, int k, int[] c) {
        if (root == null) {
            return;
        }
        inorderK(root.left, k, c);
        c[0]++;
        if (c[0] == k) {
            c[1] = root.val;
            return;
        }
        inorderK(root.right, k, c);
    }
}
