package lc.tree;

import lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 * </p>
 * <a href = https://leetcode.com/problems/sum-root-to-leaf-numbers/description/>ref</a>
 * <p>
 *     Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * </p>
 * <p>
 *     Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/22
 **/
public class L129 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(new L129().sumNumbers(head));
    }
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        recurSum(root, new StringBuilder(), res);
        return res.stream().mapToInt(Integer::valueOf).sum();
    }

    public static void recurSum(TreeNode root, StringBuilder temp, List<String> res) {
        temp.append(root.val);
        if (root.left != null) {
            recurSum(root.left, temp, res);
        }
        if (root.right != null) {
            recurSum(root.right, temp, res);
        }
        if (root.left == null && root.right == null) {
            res.add(temp.toString());
        }
        temp.deleteCharAt(temp.length()-1);
    }
}
