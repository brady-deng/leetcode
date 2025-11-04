package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.common.ob.TreeNode;
import lc.util.LUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉查找树的第k大的值
 * 8,3,10,1,6,null,14,null,null,4,7,13
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/10
 **/
public class N108Test {
    public static void main(String[] args) {
        TreeNode head = LUtil.inputTree();
        int k = LUtil.inputNum();
        System.out.println(new N108Test().getNthNode(head, k));
        System.out.println(new N108Test().getNthNode2(head, k));
    }

    public TreeNode getNthNode(TreeNode head, int k) {
        List<TreeNode> res = new ArrayList<>();
        getNthNode(head, k, res);
        return res.get(k-1);
    }

    public TreeNode getNthNode2(TreeNode head, int k) {
        Stack<TreeNode> par = new Stack<>();
        TreeNode cur = head;
        int n = 0;
        while (true) {
            while (cur != null) {
                par.push(cur);
                cur = cur.right;
            }
            if (!par.isEmpty()) {
                TreeNode node = par.pop();
                n++;
                if (n == k) return node;
                if (node.left != null) {
                    cur = node.left;
                }
            }
        }
    }

    public void getNthNode(TreeNode head, int k, List<TreeNode> res) {
        if (head == null) {
            return;
        }
        if (res.size() >= k) {
            return;
        }
        getNthNode(head.right, k, res);
        res.add(head);
        getNthNode(head.left, k, res);
    }


}
