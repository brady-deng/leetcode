package main.java.lc;

import main.java.lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L222 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(countNodes(head));
    }
    public static int countNodes(TreeNode root) {
        int[] res = new int[1];
        countNodes(root, res);
        return res[0];
    }
    public static void countNodes(TreeNode root, int[] nums) {
        if (root != null) {
            nums[0]++;
            countNodes(root.left, nums);
            countNodes(root.right, nums);
        }
    }
}
