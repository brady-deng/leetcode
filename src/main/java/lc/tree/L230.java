package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.util.LUtil;

import java.util.List;

/**
 * <p>
 *     Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * </p>
 * <a ref=https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/>ref</a>
 * <p>
 *     Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * </p>
 * <p>
 *     Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/9/23
 **/
public class L230 {
    public static void main(String[] args) {

        TreeNode head = LUtil.inputTree();
        int k = LUtil.inputNum();
        System.out.println(kthSmallest(head, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = TreeNode.inorderTraversal(root);
        return nums.get(k-1);
    }
}
