package main.java.lc.tree;

import main.java.lc.Node;

import java.util.Scanner;

/**
 * <p>
 *     You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 * </p>
 * <a href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node/>ref</a>
 * <p>
 *     [1,2,3,4,5,6,7] --> [1,#,2,3,#,4,5,6,7,#]
 * [] --> []
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/22
 **/
public class L116DFS {

    public static void main(String[] args) {
        System.out.println("Please input the string s:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Node head = Node.deserialize(s);
        Node res = connect(head);
        System.out.println(res);
    }


    public static Node connect(Node root) {
        convertList(root);
        return root;
    }

    public static void convertList(Node root) {
        if (root == null) {
            return;
        }
        else if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            convertList(root.left);
            convertList(root.right);
        }
    }
}
