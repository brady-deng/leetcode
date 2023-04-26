package main.java.lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
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
