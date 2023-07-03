package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * </p>
 * <a href = https://leetcode.com/problems/symmetric-tree/>ref</a>
 * <p>
 *     [1,2,2,3,4,4,3] --> true
 * [1,2,2,null,3,null,3] --> false
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/30
 **/
public class L101 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes");
        Scanner scanner = new Scanner(System.in);
        TreeNode root = TreeNode.deserialize(scanner.nextLine());
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left != null && right != null && left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        else {
            return false;
        }
    }

}

