package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *  Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * </p>
 * <a href=https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> [[3][20,9][15,7]]
 * [1] --> [[1]]
 * [] --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/19
 **/
public class L103Test extends L103 {

    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> prevNodes = Arrays.asList(root);
        preOrder(prevNodes, res, true);
        return res;
    }

    public void preOrder(List<TreeNode> nodes, List<List<Integer>> res, boolean isLeft) {
        nodes = nodes.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (nodes.isEmpty()) {
            return;
        }
        List<TreeNode> cur = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        for (TreeNode node: nodes) {
            cur.add(node.left);
            cur.add(node.right);
        }
        if (isLeft) {
            for (TreeNode node : nodes) {
                vals.add(node.val);
            }
        } else {
            for (int i = nodes.size()-1; i > -1; i--) {
                vals.add(nodes.get(i).val);
            }
        }
        res.add(vals);
        preOrder(cur, res, !isLeft);
    }
}
