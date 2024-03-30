package main.java.lc.tree.myTest;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.L104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * </p>
 * <a href = https://leetcode.com/problems/maximum-depth-of-binary-tree/>ref</a>
 * <p>
 *[3,9,20,null,null,15,7] --> 3
 * [1,null,2] --> 2
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L104Test extends L104 {
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> nodes = Arrays.asList(root);
        int[] res = new int[1];
        preOrder(nodes, res);
        return res[0];
    }

    public void preOrder(List<TreeNode> nodes, int[] res) {
        if (nodes.isEmpty()) {
            return;
        }
        res[0]++;
        List<TreeNode> cur = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                cur.add(node.left);
            }
            if (node.right != null) {
                cur.add(node.right);
            }
        }
        preOrder(cur, res);
    }


}
