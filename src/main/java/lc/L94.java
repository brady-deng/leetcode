package main.java.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/18
 **/
public class L94 {
    public static void main(String[] args) {
        System.out.println("Please input the string:");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(tmp);
        System.out.println(inorderTraversal(head));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Traversal(root, res);
        return res;
    }

    public static void Traversal(TreeNode head, List<Integer> res) {
        if (head.left != null) {
            Traversal(head.left, res);
        }
        res.add(head.val);
        if (head.right != null) {
            Traversal(head.right, res);
        }
    }


}
