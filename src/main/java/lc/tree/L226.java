package lc.tree;

import lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the root of a binary tree, invert the tree, and return its root.
 * </p>
 * <a href=https://leetcode.com/problems/invert-binary-tree/description/>ref</a>
 * <p>
 *     Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * </p>
 * <p>
 *     Input: root = [2,1,3]
 * Output: [2,3,1]
 * </p>
 * <p>
 *     Input: root = []
 * Output: []
 * </p>
 * <p>
 *     easy
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L226 {
    public static void main(String[] args) {
        System.out.println("please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(invertTree(head));
    }
    public static TreeNode invertTree(TreeNode root) {
        return recurInvert(root);
    }
    public static TreeNode recurInvert(TreeNode root) {
        if (root == null) {
            return root;
        }
        else if (root.left == null && root.right == null) {
            return root;
        }
        else {
            TreeNode left = recurInvert(root.left);
            TreeNode right = recurInvert(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
