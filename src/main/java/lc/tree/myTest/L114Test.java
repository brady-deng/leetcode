package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L114;

/**
 * <p>
 *     Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * </p>
 * <a href=https://leetcode.com/problems/flatten-binary-tree-to-linked-list/>ref</a>
 * <p>
 *     [1,2,5,3,4,null,6] --> [1,null,2,null,3,null,4,null,5,null,6]
 * [] --> []
 * [0] --> [0]
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/21
 **/
public class L114Test extends L114 {

    @Override
    public void flatten(TreeNode root) {
        super.flatten(root);
    }
}
