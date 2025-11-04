package lc.tree;

import lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L199 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode root = TreeNode.deserialize(scanner.nextLine());
        System.out.println(new L199().rightSideView(root));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            recurRightView(Collections.singletonList(root), res);
        }
        return res;
    }
    public void recurRightView(List<TreeNode> parentNode, List<Integer> res) {
        if (!parentNode.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            boolean found = false;
            for (TreeNode item:parentNode) {
                if (item.right != null) {
                    if (!found) {
                        res.add(item.right.val);
                        found = true;
                    }
                    next.add(item.right);
                }
                if (item.left != null) {
                    if (!found) {
                        res.add(item.left.val);
                        found = true;
                    }
                    next.add(item.left);
                }
            }
            recurRightView(next, res);
        }
    }
}
