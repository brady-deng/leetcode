package main.java.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/27
 **/
public class L144 {
    public static void main(String[] args) {
        System.out.println("Please input the tree nodes:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println(new L144().preorderTraversal(head));
        System.out.println(new L144().postorderTraversal(head));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                traversal(root.left, res);
            }
            if (root.right != null) {
                traversal(root.right, res);
            }
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postTraversal(root, res);
        return res;
    }
    public void postTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                postTraversal(root.left, res);
            }
            if (root.right != null) {
                postTraversal(root.right, res);
            }
            res.add(root.val);
        }
    }
}
