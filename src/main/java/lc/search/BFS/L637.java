package main.java.lc.search.BFS;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 * </p>
 * <a href=https://leetcode.com/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231215
 **/
public class L637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            Double tmp = Double.valueOf(cur.stream().mapToLong(item->{return Long.valueOf(item.val);}).sum())/cur.size();
            res.add(tmp);
            cur = bfsNode(cur);
        }
        return res;
    }

    public List<TreeNode> bfsNode(List<TreeNode> nodes) {
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode node:nodes) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
        }
        return res;
    }
}
