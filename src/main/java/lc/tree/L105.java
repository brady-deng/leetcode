package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * </p>
 * <a href=https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/>ref</a>
 * <p>
 *     [3,9,20,15,7]
 * [9,3,15,20,7] --> [3,9,20,null,null,15,7]
 * </p>
 * <p>
 * [-1]
 * [-1] --> [-1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/20
 **/
public class L105 {

    public static void main(String[] args) {
        System.out.println("Please input the s1:");
        Scanner scanner = new Scanner(System.in);
        int[] pre = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the s2:");
        int[] in = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        TreeNode head = buildTree(pre, in);
        System.out.println(head);
    }



    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return tree(preorder, inorder, 0, 0, inorder.length);
    }


    /**
     *
     * @param preorder
     * @param inorder
     * @param index the head index of preorder
     * @param start the start index of inorder
     * @param end the end index of inorder
     * @return
     */
    public static TreeNode tree(int[] preorder, int[] inorder, int index, int start, int end) {
        int headVal = preorder[index];
        TreeNode head = new TreeNode(headVal);
        if (end-start <= 1) return head;
        else {
            for (int i = start; i < end; i++) {
                // 中序遍历中跟节点的位置
                if (inorder[i] == headVal) {
                    // 跟节点左边还有节点
                    if (i>start) {
                        // index的左子节点
                        head.left = tree(preorder, inorder, index+1, start, i);
                    }
                    // 跟节点右边还有节点
                    if (i < end-1) {
                        // index的右子节点
                        head.right = tree(preorder, inorder, index+i-start+1, i+1, end);
                    }
                    break;
                }
            }
            return head;
        }
    }
}
