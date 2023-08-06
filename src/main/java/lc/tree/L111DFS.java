package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * <p>
 *     Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 * </p>
 * <a href=https://leetcode.com/problems/minimum-depth-of-binary-tree/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> 2
 * [2,null,3,null,4,null,5,null,6] --> 5
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L111DFS {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(minDepth(head));
        System.out.println(new L111BFS().minDepth(head));
    }
    public static int minDepth(TreeNode root) {
        if (root != null) {
            int[] min = new int[]{Integer.MAX_VALUE};
            int depth = 0;
            miniDepth(root, depth, min);
            return min[0];
        }
        else {
            return 0;
        }
    }

    public static void miniDepth(TreeNode root, int depth, int[] min) {
        if (root != null) {
            depth++;
            if (root.left != null) {
                miniDepth(root.left, depth, min);
            }
            if (root.right != null) {
                miniDepth(root.right, depth, min);
            }
            if (root.left == null && root.right == null) {
                if (depth < min[0]) {
                    min[0] = depth;
                }
            }
        }
    }
}
