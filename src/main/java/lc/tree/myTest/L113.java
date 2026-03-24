package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L113DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * </p>
 * <a href=https://leetcode.com/problems/path-sum-ii/>ref</a>
 * <p>
 *     [5,4,8,11,null,13,4,7,2,null,null,5,1]
 * 22 --> [[5,4,11,2],[5,8,4,5]]
 * [1,2,3]
 * 5 --> []
 * [1,2]
 * 0 --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/21
 **/
public class L113 extends L113DFS {

    @Override
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        path(root, new ArrayList<>(), res, targetSum);
        return res;
    }

    public void path(TreeNode root, List<Integer> vals, List<List<Integer>> res, int target) {
        if (root == null) {
            return;
        }
        vals.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(vals));
        }
        path(root.left, vals, res, target-root.val);
        path(root.right, vals, res, target-root.val);
        vals.remove(vals.size()-1);
    }
}
