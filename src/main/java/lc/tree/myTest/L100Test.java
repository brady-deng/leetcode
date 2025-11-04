package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L100;

/**
 * <p>
 *     Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * </p>
 * <a href = https://leetcode.com/problems/same-tree/>ref</a>
 * <p>
 *     [1,2,3]
 *      [1,2,3] --> true
 * [1,2]
 * [1,null,2]
 * --> false
 * [1,2,1]
 * [1,1,2]
 * --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 **/
public class L100Test extends L100 {

    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return super.isSameTree(p, q);
    }
}
