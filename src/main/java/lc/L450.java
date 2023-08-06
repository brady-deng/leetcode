package main.java.lc;

import main.java.lc.common.ob.TreeNode;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/9
 **/
public class L450 {
    public static void main(String[] args) {
        TreeNode head = LUtil.inputTree();
        int key = LUtil.inputNum();
        System.out.println(deleteNode(head, key));
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            }
            else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            }
            else {
                if (parent == null) {
                    TreeNode tmpCur = null;
                    if (cur.right != null) {
                        tmpCur = cur.right;
                        while (tmpCur.left != null) {
                            tmpCur = tmpCur.left;
                        }
                        tmpCur.left = cur.left;
                        return cur.right;
                    }
                    else if (cur.left != null) {
                        tmpCur = cur.left;
                        while (tmpCur.right != null) {
                            tmpCur = tmpCur.right;
                        }
                        tmpCur.right = cur.right;
                        return cur.left;
                    }
                    return null;
                }
                else if (parent.right == cur) {
                    if (cur.right != null) {
                        parent.right = cur.right;
                        TreeNode tmpCur = cur.right;
                        while (tmpCur.left != null) {
                            tmpCur = tmpCur.left;
                        }
                        tmpCur.left = cur.left;
                    }
                    else if (cur.left != null) {
                        parent.right = cur.left;
                        TreeNode tmpCur = cur.left;
                        while (tmpCur.right != null) {
                            tmpCur = tmpCur.right;
                        }
                        tmpCur.right = cur.right;
                    }
                    else {
                        parent.right = null;
                    }
                }
                else if (parent.left == cur) {
                    if (cur.right != null) {
                        parent.left = cur.right;
                        TreeNode tmpCur = cur.right;
                        while (tmpCur.left != null) {
                            tmpCur = tmpCur.left;
                        }
                        tmpCur.left = cur.left;
                    }
                    else if (cur.left != null) {
                        parent.left = cur.left;
                        TreeNode tmpCur = cur.left;
                        while (tmpCur.right != null) {
                            tmpCur = tmpCur.right;
                        }
                        tmpCur.right = cur.right;
                    }
                    else {
                        parent.left = null;
                    }
                }
                return root;
            }
        }
        return root;
    }
}
