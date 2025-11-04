package lc.tree;

import lc.common.ob.TreeNode;
import lc.tree.myTest.L110Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>
 *     Given a binary tree, determine if it is
 * height-balanced
 * .
 * </p>
 * <a href = https://leetcode.com/problems/balanced-binary-tree/>ref</a>
 * <p>
 *     [3,9,20,null,null,15,7] --> true
 * [1,2,2,3,3,null,null,4,4] --> false
 * [] --> true
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/26
 **/
public class L110 {
    public static void main(String[] args) {
        System.out.println("Please input the treenodes:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode node = TreeNode.deserialize(s);
        System.out.println(new L110().isBalanced(node));
        System.out.println(new L110Test().isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        return validBalaned(root);
    }

    public boolean validBalaned(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        getLength(root, map);
        if (root != null) {
            if (root.left != null && root.right != null) {
                if (Math.abs(map.getOrDefault(root.left.hashCode(), 0) - map.getOrDefault(root.right.hashCode(), 0)) >1) {
                    return false;
                }
            }
            else if (root.left != null) {
                return map.get(root.left.hashCode()) < 1;
            }
            else if (root.right != null){
                return map.get(root.right.hashCode()) < 1;
            }
            else {
                return true;
            }
            return validBalaned(root.left) && validBalaned(root.right);
        }
        return true;
    }
    public static int getLength(TreeNode root, Map<Integer, Integer> map) {
        if (root!= null) {
            if (root.left != null && root.right != null) {
                int res = Math.max(getLength(root.left, map), getLength(root.right, map)) + 1;
                map.put(root.hashCode(), res);
                return res;
            }
            else if (root.left != null) {
                int res = getLength(root.left, map)+1;
                map.put(root.hashCode(), res);
                return res;
            }
            else if (root.right != null) {
                int res = getLength(root.right, map)+1;
                map.put(root.hashCode(), res);
                return res;
            }
            else {
                map.put(root.hashCode(), 1);
                return 1;
            }
        }
        return 0;
    }
}
