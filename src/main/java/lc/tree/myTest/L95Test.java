package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L95;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * </p>
 * <a href = https://leetcode.com/problems/unique-binary-search-trees-ii/>ref</a>
 * <p>
 *     3 -->[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *      1 --> [1]
 * </p>
 */
public class L95Test extends L95 {


    @Override
    public List<TreeNode> generateTrees(int n) {
        return constructSubTree(1, n);
    }


    public List<TreeNode> constructSubTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = constructSubTree(start, i-1);
            List<TreeNode> right = constructSubTree(i+1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    res.add(n);
                }
            }
        }
        return res;
    }
}
