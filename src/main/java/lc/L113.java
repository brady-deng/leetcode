package main.java.lc;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/21
 **/
public class L113 {
    public static void main(String[] args) {
        System.out.println("Please input the bst:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println("Please input the target:");
        int tar = scanner.nextInt();
        System.out.println(pathSum(head, tar));
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        getSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    public static void getSum(TreeNode root, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (null != root) {
            tmp.add(root.val);
            if (target-root.val == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList<Integer>(tmp));
            }
            else {
                if (null != root.left) {
                    getSum(root.left, target-root.val, new ArrayList<>(tmp), res);
                }
                if (null != root.right) {
                    getSum(root.right, target-root.val, new ArrayList<>(tmp), res);
                }
            }
        }
        else {
            return;
        }

    }

}
