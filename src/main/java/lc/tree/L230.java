package lc.tree;

import lc.common.ob.TreeNode;
import lc.tree.myTest.L230Test;
import lc.util.LUtil;

import java.util.List;

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
public class L230 {
    public static void main(String[] args) {

        TreeNode head = LUtil.inputTree();
        int k = LUtil.inputNum();
        System.out.println(new L230().kthSmallest(head, k));
        System.out.println(new L230Test().kthSmallest(head, k));
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = TreeNode.inorderTraversal(root);
        return nums.get(k-1);
    }
}
