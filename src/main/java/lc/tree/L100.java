package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.Scanner;

/**
 * <p>
 *     Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * </p>
 * <a href = https://leetcode.com/problems/same-tree/>ref</a>
 * <p>
 *     [1,2,3]
 *      [1,2,3] --> true
 * [1,2]
 * [1,null,2]
 * --> false
 * [1,2,1]
 * [1,1,2]
 * --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 **/
public class L100 {

    public static void main(String[] args) {
        System.out.println("Please input the nodes1:");
        Scanner scanner = new Scanner(System.in);
        String tmp1 = scanner.nextLine();
        TreeNode h1 = TreeNode.deserialize(tmp1);
        System.out.println("Please input the nodes2:");
        String tmp2 = scanner.nextLine();
        TreeNode h2 = TreeNode.deserialize(tmp2);
        System.out.println(isSameTree(h1, h2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q && p == null) return true;
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;
        if (p.val != q.val) return false;
        if (p.left != null && q.left != null && p.left.val!= q.left.val) return false;
        if (p.right != null && q.right != null && p.right.val != q.right.val) return false;
        if (p.left == null && q.left != null) return false;
        else if (p.left != null && q.left == null) return false;
        if (p.right == null && q.right != null) return false;
        else if (p.right != null && q.right == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
