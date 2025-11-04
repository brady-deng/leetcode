package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L101;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * </p>
 * <a href = https://leetcode.com/problems/symmetric-tree/>ref</a>
 * <p>
 *     [1,2,2,3,4,4,3] --> true
 * [1,2,2,null,3,null,3] --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L101Test extends L101 {

    @Override
    public boolean isSymmetric(TreeNode root) {
        List<Integer> nums = inorderVals(root);
        int l = 0, r = nums.size()-1;
        while (l < r) {
            if (nums.get(l++) != nums.get(r--)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inorderVals(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderVals(root.left));
        res.add(root.val);
        res.addAll(inorderVals(root.right));
        return res;
    }
}
