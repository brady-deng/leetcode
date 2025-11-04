package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L106;

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
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/20
 **/
public class L106Test extends L106 {

    @Override
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }


    public TreeNode buildTree(int[] inorder, int[] postorder, int index, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == postorder[index]) {
                mid = i;
                break;
            }
        }
        TreeNode head = new TreeNode(inorder[mid]);
        if (mid > start) {
            head.left = buildTree(inorder, postorder, index-(end-mid)-1, start, mid-1);
        }
        if (mid < end) {
            head.right = buildTree(inorder, postorder, index-1, mid+1, end);
        }
        return head;
    }
}
