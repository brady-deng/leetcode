package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * </p>
 * <a href = https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/>ref</a>
 * <p>
 *     [9,3,15,20,7]
 * [9,15,7,20,3] --> [3,9,20,null,null,15,7]
 * </p>
 * <p>
 * [-1]
 * [-1] --> [-1]
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/20
 **/
public class L106 {
    public static void main(String[] args) {
        System.out.println("Please input the s1:");
        Scanner scanner = new Scanner(System.in);
        int[] pre = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the s2:");
        int[] in = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        TreeNode head = buildTree(pre, in);
        System.out.println(head);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return tree(inorder, postorder, 0, postorder.length, 0, inorder.length);
    }

    public static TreeNode tree(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        int headVal = postorder[e1-1];
        TreeNode head = new TreeNode(headVal);
        if (e1-s1 <= 1) return head;
        for (int i = s2; i < e2; i++) {
            if (inorder[i] == headVal) {
                if (i != s2) {
                    head.left = tree(inorder, postorder, s1, s1+i-s2, s2, i);
                    if (i-s2+s1 < e1-1) {
                        head.right = tree(inorder, postorder, s1+i-s2, e1-1, i+1, e2);
                    }
                    break;
                }
                else if (s1 < e1-1) {
                    head.right = tree(inorder, postorder, s1, e1-1, i+1, e2);
                }
                break;
            }
        }
        return head;
    }
}
