package lc.tree;

import lc.common.ob.TreeNode;
import lc.tree.myTest.L113;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 /**
 * <p>
 *     Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * </p>
 * <a href=https://leetcode.com/problems/path-sum-ii/>ref</a>
 * <p>
 *     [5,4,8,11,null,13,4,7,2,null,null,5,1]
 * 22 --> [[5,4,11,2],[5,8,4,5]]
 * [1,2,3]
 * 5 --> []
 * [1,2]
 * 0 --> []
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/21
 **/
public class L113DFS {
    public static void main(String[] args) {
        System.out.println("Please input the bst:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println("Please input the target:");
        int tar = scanner.nextInt();
        System.out.println(new L113DFS().pathSum(head, tar));
        System.out.println(new L113().pathSum(head, tar));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        getSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    public void getSum(TreeNode root, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (null != root) {
            tmp.add(root.val);
            if (target-root.val == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList<Integer>(tmp));
            }
            else {
                if (null != root.left) {
                    getSum(root.left, target-root.val, tmp, res);
                }
                if (null != root.right) {
                    getSum(root.right, target-root.val, tmp, res);
                }
            }
            tmp.remove(tmp.size()-1);
        }
        else {
            return;
        }

    }

}
