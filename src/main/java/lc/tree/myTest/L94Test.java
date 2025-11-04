package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L94;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * </p>
 * <a href = https://leetcode.com/problems/binary-tree-inorder-traversal/>ref</a>
 * <p>
 *     [1,null,2,3] --> [1,3,2]
 *      [] --> []
 *      [1] --> [1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 **/
public class L94Test extends L94 {


    @Override
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }


}
