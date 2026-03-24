package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L99Ans;

/**
 * <p>
 *     You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * </p>
 * <a href = https://leetcode.com/problems/recover-binary-search-tree/>ref</a>
 * <p>
 *     [1,3,null,null,2] --> [3,1,null,null,2]
 *     [3,1,4,null,null,2] --> [2,1,4,null,null,3]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/16
 **/
public class L99Test extends L99Ans {

    @Override
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null, first = root, second = root;
        findUnValidNode(root, prev, first, second);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void findUnValidNode(TreeNode root, TreeNode prev, TreeNode first, TreeNode second) {
        if (root == null) {
            return;
        }
        findUnValidNode(root.left, prev, first, second);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        findUnValidNode(root.right, prev, first, second);
    }
}
