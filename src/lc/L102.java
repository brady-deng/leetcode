package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
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
        res.add(tmp);
        if (thisLevel.isEmpty()) {
            return;
        }
        getNodes(thisLevel, res);
    }
}
