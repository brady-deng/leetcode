package main.java.lc;

import main.java.lc.common.ob.TreeNode;

import java.util.Scanner;

/**
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

