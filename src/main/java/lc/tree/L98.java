package lc.tree;

import lc.common.ob.TreeNode;
import lc.tree.myTest.L98Test;

import java.util.Scanner;

/**
 * <p>
 *     Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * </p>
 * <a href = https://leetcode.com/problems/validate-binary-search-tree/>ref</a>
 * <p>
 *     [2,1,3] --> true
 *      [5,1,4,null,null,3,6] --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/16
 **/
public class L98 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println(new L98().isValidBST(head));
        System.out.println(new L98Test().isValidBST(head));

    }

    public boolean isValidBST(TreeNode root) {


        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isBST(TreeNode root,long min,long max)
    {
        if(root == null) {
            return true;
        }

        //System.out.println(root.val + " "+min + " "+max);
        if(root.val <= min || root.val >= max)
            return false;

        boolean left = isBST(root.left,min,root.val);
        boolean right = isBST(root.right,root.val,max);
        return left && right;
    }
}
