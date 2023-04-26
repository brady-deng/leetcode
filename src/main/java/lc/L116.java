package main.java.lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/22
 **/
public class L116 {

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
