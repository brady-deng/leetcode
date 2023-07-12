package main.java.lc.tree;

import main.java.lc.Node;

import java.util.Scanner;

/**
 * <p>
 *     Given a binary tree
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
 * <a href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/>ref</a>
 * <p>
 *     [1,2,3,4,5,null,7] --> [1,#,2,3,#,4,5,7,#]
 * [] --> []
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/22
 **/
public class L117 {
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
            if (root.right != null) {
                root.left.next = root.right;
                Node tmp = root;
                while (tmp.next != null) {
                    if (tmp.next.left!= null) {
                        root.right.next = tmp.next.left;
                        break;
                    }
                    else if (tmp.next.right != null) {
                        root.right.next = tmp.next.right;
                        break;
                    }
                    tmp = tmp.next;
                }
            }
            else if (root.next != null) {
                Node tmp = root;
                while (tmp.next != null) {
                    if (tmp.next.left!= null) {
                        root.left.next = tmp.next.left;
                        break;
                    }
                    else if (tmp.next.right != null) {
                        root.left.next = tmp.next.right;
                        break;
                    }
                    tmp = tmp.next;
                }
            }
        }
        else if (root.right != null) {
            if (root.next != null) {
                Node tmp = root;
                while (tmp.next != null) {
                    if (tmp.next.left!= null) {
                        root.right.next = tmp.next.left;
                        break;
                    }
                    else if (tmp.next.right != null) {
                        root.right.next = tmp.next.right;
                        break;
                    }
                    tmp = tmp.next;
                }
            }
        }
        convertList(root.right);
        convertList(root.left);
    }
}
