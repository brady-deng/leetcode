package lc.node.mytest;

import lc.common.ob.TreeNode;

import java.util.Stack;

/**
 * 中序遍历的下一个节点
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/10
 **/
public class N112 {



    public TreeNode inOrderTree(TreeNode head, TreeNode tar) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode cur = head;
        boolean flag = false;
        while(true) {
            while(cur != null) {
                nodes.push(cur);
                cur = cur.left;
            }
            if (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                if (flag) {
                    return node;
                }
                if (node == tar) {
                    flag = true;
                }
                cur = node.right;
            }
        }
    }
}
