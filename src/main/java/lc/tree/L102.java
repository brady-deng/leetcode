package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * </p>
 * <a href = https://leetcode.com/problems/binary-tree-level-order-traversal/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> [[3],[9,20],[15,7]]
 * [1] --> [[1]]
 * [] --> []
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/19
 **/
public class L102 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(tmp);
        System.out.println(levelOrder(head));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            getNodes(Collections.singletonList(root), res);
        }
        return res;
    }

    public static void getNodes(List<TreeNode> pre, List<List<Integer>> res) {
        List<Integer> tmp = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode item:pre) {
            tmp.add(item.val);
            if (item.left != null) {
                nextLevel.add(item.left);
            }
            if (item.right != null) {
                nextLevel.add(item.right);
            }
        }
        res.add(tmp);
        if (nextLevel.isEmpty()) {
            return;
        }
        getNodes(nextLevel, res);
    }
}
