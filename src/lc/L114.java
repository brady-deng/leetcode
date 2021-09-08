package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/21
 **/
public class L114 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String nodes = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(nodes);
        flatten(head);
        System.out.println(head);
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> preOrder = new ArrayList<>();
        preOrder(root, preOrder);
        buildFlat(preOrder);
    }

    public static TreeNode buildFlat(List<TreeNode> tmp) {
        if (!tmp.isEmpty()) {
            TreeNode head = tmp.get(0);
            head.left = null;
            TreeNode cur = head;
            for (int i = 1; i < tmp.size(); i++) {
                tmp.get(i).left = null;
                cur.right = tmp.get(i);
                cur.left = null;
                if (i != tmp.size()-1) {
                    cur = cur.right;
                }
            }
            return head;
        }
        else {
            return null;
        }
    }

    public static void preOrder(TreeNode root, List<TreeNode> tmp) {
        if (root != null) {
            tmp.add(root);
            if (root.left != null) {
                preOrder(root.left, tmp);
            }
            if (root.right != null) {
                preOrder(root.right, tmp);
            }
        }
    }
}
