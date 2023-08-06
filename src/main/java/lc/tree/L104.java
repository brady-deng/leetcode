package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * </p>
 * <a href = https://leetcode.com/problems/maximum-depth-of-binary-tree/>ref</a>
 * <p>
 *[3,9,20,null,null,15,7] --> 3
 * [1,null,2] --> 2
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L104 {

    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode root = TreeNode.deserialize(scanner.nextLine());
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        int[] max = new int[]{0};
        recurMaxDepth(root, depth, max);
        return max[0];
    }

    public static void recurMaxDepth(TreeNode root, int depth, int[] max) {
        if (root != null) {
            depth++;
            if (depth > max[0]) max[0] = depth;
            recurMaxDepth(root.left, depth, max);
            recurMaxDepth(root.right, depth, max);
        }
    }
}
