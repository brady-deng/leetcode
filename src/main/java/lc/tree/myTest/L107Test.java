package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * </p>
 * <a href = https://leetcode.com/problems/binary-tree-level-order-traversal-ii/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> [[15,7],[9,20],[3]]
 * [1] --> [[1]]
 * [] --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/20
 **/
public class L107Test extends L107 {

    @Override
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<List<TreeNode>> nodes = new Stack<>();
        List<TreeNode> cur = Arrays.asList(root);
        recurTree(cur, nodes);
        while (!nodes.isEmpty()) {
            List<TreeNode> tmp = nodes.pop();
            List<Integer> vals = tmp.stream().map(item->item.val).collect(Collectors.toList());
            res.add(vals);
        }
        return res;
    }

    public void recurTree(List<TreeNode> cur, Stack<List<TreeNode>> nodes) {
        if (cur.isEmpty()) {
            return;
        }
        nodes.push(cur);
        List<TreeNode> next = new ArrayList<>();
        for (TreeNode node : cur) {
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
        }
        recurTree(next, nodes);
    }





}
