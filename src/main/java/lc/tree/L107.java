package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.tree.myTest.L107Test;

import java.util.*;

/**
 * <p>
 *     Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * </p>
 * <a href = https://leetcode.com/problems/binary-tree-level-order-traversal-ii/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> [[15,7],[9,20],[3]]
 * [1] --> [[1]]
 * [] --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/20
 **/
public class L107 {
    public static void main(String[] args) {
        System.out.println("Please input the s:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println(new L107().levelOrderBottom(head));
        System.out.println(new L107Test().levelOrderBottom(head));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null != root) {
            List<List<Integer>> tmp = new ArrayList<>();
            getStact(Collections.singletonList(root), tmp);
            while (!tmp.isEmpty()) {
                res.add(tmp.remove(tmp.size()-1));
            }
        }
        return res;
    }

    public void getStact(List<TreeNode> head, List<List<Integer>> res) {
        if (!head.isEmpty()) {
            List<TreeNode> nextNodes = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            head.forEach(item->{
                tmp.add(item.val);
                if (item.left != null) {
                    nextNodes.add(item.left);
                }
                if (item.right != null) {
                    nextNodes.add(item.right);
                }
            });
            res.add(tmp);
            getStact(nextNodes, res);
        }
        else {
            return;
        }

    }
}
