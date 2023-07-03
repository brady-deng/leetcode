package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 * </p>
 * <a href = https://leetcode.com/problems/unique-binary-search-trees-ii/>ref</a>
 * <p>
 *     3 -->[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *      1 --> [1]
 * </p>
 */
public class L95 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<TreeNode> res = generateTrees(n);
        System.out.println(res);
        List<TreeNode> res2 = new L95Ans().generateTrees(n);
        System.out.println(res2);
    }
    public static List<TreeNode> generateTrees(int n) {
        if (n > 1) {
            List<TreeNode> res = new ArrayList<>();
            List<TreeNode> tmpRes = generateTrees(n-1);
            tmpRes.forEach(item->{
                TreeNode treeNode = new TreeNode(n);
                treeNode.left = item;
                res.add(treeNode);
                TreeNode tmp = copyTreeNode(item);
                TreeNode head = tmp;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = new TreeNode(n);
                res.add(head);
            });
            return res;
        }
        else {
            return new ArrayList<TreeNode>() {{
               add(new TreeNode(1));
            }};
        }
    }
    public static TreeNode copyTreeNode(TreeNode head) {
        if (head != null) {
            return new TreeNode(head.val, copyTreeNode(head.left), copyTreeNode(head.right));
        }
        else {
            return null;
        }
    }
}
