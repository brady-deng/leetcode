package lc.tree.myTest;

import lc.common.ob.TreeNode;
import lc.tree.L199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * </p>
 * <a href=https://leetcode.com/problems/binary-tree-right-side-view/description/>ref</a>
 * <p>
 *     Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * </p>
 * <p>
 *     Input: root = [1,null,3]
 * Output: [1,3]
 * </p>
 * <p>
 *     Input: root = []
 * Output: []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L199Test extends L199 {

    @Override
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        recurTreeNode(root, Arrays.asList(root), res);
        return res;
    }

    public void recurTreeNode(TreeNode root, List<TreeNode> cur, List<Integer> res) {
        if (cur.isEmpty()) {
            return;
        }
        List<TreeNode> tmp = new ArrayList<>();
        for (TreeNode node : cur) {
            if (node.left != null) {
                tmp.add(node.left);
            }
            if (node.right != null) {
                tmp.add(node.right);
            }
        }
        res.add(cur.get(cur.size()-1).val);
        recurTreeNode(root, tmp, res);
    }
}
