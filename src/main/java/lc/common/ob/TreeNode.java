package main.java.lc.common.ob;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode deserialize(String string) {
        if ("{}".equals(string) || "".equals(string)) {
            return null;
        }
        List<TreeNode> nodes = Arrays.stream(string.split(",")).map(item->{
            if ("null".equals(item)) {
                return null;
            }
            else {
                return new TreeNode(Integer.parseInt(item));
            }
        }).collect(Collectors.toList());
        List<TreeNode> kids = new ArrayList<>(nodes);
        TreeNode root = kids.remove(0);
        for (TreeNode node:nodes) {
            if (node!=null) {
                if (!kids.isEmpty()) {
                    node.left = kids.remove(0);
                }
                if (!kids.isEmpty()) {
                    node.right = kids.remove(0);
                }
            }
        }
        return root;

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Traversal(root, res);
        return res;
    }

    public static void Traversal(TreeNode head, List<Integer> res) {
        if (head.left != null) {
            Traversal(head.left, res);
        }
        res.add(head.val);
        if (head.right != null) {
            Traversal(head.right, res);
        }
    }
}
