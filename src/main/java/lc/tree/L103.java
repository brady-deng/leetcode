package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *  Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * </p>
 * <a href=https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> [[3][20,9][15,7]]
 * [1] --> [[1]]
 * [] --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/19
 **/
public class L103 {
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
            getNodes(Collections.singletonList(root), res, true);
        }
        return res;
    }

    public static void getNodes(List<TreeNode> pre, List<List<Integer>> res, boolean flag) {
        List<Integer> tmp = new ArrayList<>();
        List<TreeNode> thisLevel = new ArrayList<>();
        for (TreeNode item:pre) {
            tmp.add(item.val);
            if (item.left != null) {
                thisLevel.add(item.left);
            }
            if (item.right != null) {
                thisLevel.add(item.right);
            }
        }
        if (!flag) {
            List<Integer> tmpTran = new ArrayList<>();
            while (!tmp.isEmpty()) {
                tmpTran.add(tmp.remove(tmp.size()-1));
            }
            res.add(tmpTran);
        }
        else {
            res.add(tmp);
        }
        if (thisLevel.isEmpty()) {
            return;
        }
        getNodes(thisLevel, res, !flag);
    }
}
