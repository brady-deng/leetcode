package lc.tree;

import lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 * </p>
 * <a href=https://leetcode.com/problems/count-complete-tree-nodes/description/>ref</a>
 * <p>
 *     Input: root = [1,2,3,4,5,6]
 * Output: 6
 * </p>
 * <p>
 *     Input: root = []
 * Output: 0
 * </p>
 * <p>
 *     Input: root = [1]
 * Output: 1
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L222 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(new L222().countNodes(head));
    }
    public int countNodes(TreeNode root) {
        int[] res = new int[1];
        countNodes(root, res);
        return res[0];
    }
    public void countNodes(TreeNode root, int[] nums) {
        if (root != null) {
            nums[0]++;
            countNodes(root.left, nums);
            countNodes(root.right, nums);
        }
    }
}
