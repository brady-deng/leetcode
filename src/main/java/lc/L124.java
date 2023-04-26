package main.java.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
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
