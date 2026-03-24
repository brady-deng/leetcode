package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * </p>
 * <a href = https://leetcode.com/problems/binary-tree-level-order-traversal/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> [[3],[9,20],[15,7]]
 * [1] --> [[1]]
 * [] --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/19
 **/
public class L102Test extends L102 {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(Arrays.asList(root.val));
        List<TreeNode> prevNodes = Arrays.asList(root);
        preOrder(prevNodes, res);
        return res;
    }

    public void preOrder(List<TreeNode> nodes, List<List<Integer>> res) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Integer> curVals = new ArrayList<>();
        List<TreeNode> curs = new ArrayList<>();
        for (TreeNode node: nodes) {
            if (node.left != null) {
                curVals.add(node.left.val);
                curs.add(node.left);
            }
            if (node.right != null) {
                curVals.add(node.right.val);
                curs.add(node.right);
            }
        }
        if (!curVals.isEmpty()) {
            res.add(curVals);
        }
        preOrder(curs, res);
    }
}
