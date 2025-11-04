package lc.tree.myTest;

import lc.Node;
import lc.tree.L117;

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
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class L117Test extends L117 {

    @Override
    public Node connect(Node root) {
        connect2(root);
        return root;
    }

    public void connect2(Node root) {
        Node dummyHead = new Node();
        Node pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                root = dummyHead.next;
                pre = dummyHead;
                dummyHead.next = null;
            }
        }
    }


    public void recurConnect(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
                Node next = root.next;
                while (next != null) {
                    if (next.left != null) {
                        root.right.next = next.left;
                        break;
                    } else if (next.right != null) {
                        root.right.next = next.right;
                        break;
                    }
                    next = next.next;
                }
            } else {
                Node next = root.next;
                while (next != null) {
                    if (next.left != null) {
                        root.left.next = next.left;
                        break;
                    } else if (next.right != null) {
                        root.left.next = next.right;
                        break;
                    }
                    next = next.next;
                }
            }
        } else if (root.right != null) {
            Node next = root.next;
            while (next != null) {
                if (next.left != null) {
                    root.right.next = next.left;
                    break;
                } else if (next.right != null) {
                    root.right.next = next.right;
                    break;
                }
                next = next.next;
            }
        }
        recurConnect(root.right);
        recurConnect(root.left);
    }
}
