package main.java.lc.tree;

import main.java.lc.common.ob.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 /**
 *
 * <p>
 *     A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * </p>
 * <a href=https://leetcode.com/problems/binary-tree-maximum-path-sum/description/>ref</a>
 * <p>
 *     [1,2,3] --> 6
 * [-10,9,20,null,null,15,7] --> 42
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/30
 **/
public class L124 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(maxPathSum(head));
    }

    public static class PathNode {
        public List<PathNode> neighbors;
        public boolean visited;
        public int val;

        public PathNode(int val) {
            this.val = val;
            this.visited = false;
            this.neighbors = new ArrayList<>();
        }
    }
    public static int maxPathSum(TreeNode root) {
        List<PathNode> tmp = new ArrayList<>();
        recurTraver(root, tmp, null);
        int[] res = new int[]{Integer.MIN_VALUE};
        findMax(tmp, res);
        return res[0];
    }

    public static void findMax(List<PathNode> tmp, int[] res) {
        for (PathNode pathNode:tmp) {

            recurFindMax(pathNode, res, 0);

        }
    }

    public static void recurFindMax(PathNode tmp, int[] res, int temp) {
        temp+=tmp.val;
        tmp.visited = true;
        if (temp > res[0]) res[0] = temp;
        for (PathNode item:tmp.neighbors) {
            if (!item.visited) {
                recurFindMax(item, res, temp);
            }
        }
        tmp.visited = false;
    }

    public static void recurTraver(TreeNode node, List<PathNode> tmp, PathNode parent) {
        if (node != null) {
            PathNode pathNode = new PathNode(node.val);
            if (parent != null) {
                pathNode.neighbors.add(parent);
                parent.neighbors.add(pathNode);
            }
            tmp.add(pathNode);
            recurTraver(node.left, tmp, pathNode);
            recurTraver(node.right, tmp, pathNode);
        }
    }
}
