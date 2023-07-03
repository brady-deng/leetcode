package main.java.lc;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/22
 **/
public class L129 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(sumNumbers(head));
    }
    public static int sumNumbers(TreeNode root) {
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
