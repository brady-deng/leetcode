package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L105;

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
public class L105Test extends L105 {

    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTree(preorder, inorder, 0, 0, inorder.length-1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int root, int start, int end) {
        if (start == end) {
            return new TreeNode(preorder[root]);
        }
        if (start > end) {
            return null;
        }
        int mid = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[root]) {
                mid = i;
                break;
            }
        }
        TreeNode head = new TreeNode(preorder[root]);
        if (mid > start) {
            head.left = buildTree(preorder, inorder, root+1, start, mid-1);
        }
        if (mid < end) {
            head.right = buildTree(preorder, inorder, root+mid-start+1, mid+1, end);
        }
        return head;
    }
}
