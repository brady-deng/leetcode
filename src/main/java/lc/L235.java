package main.java.lc;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.util.LUtil;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/9
 **/
public class L235 {
    public static void main(String[] args) {
        TreeNode head = LUtil.inputTree();
        TreeNode p = LUtil.inputTree();
        TreeNode q = LUtil.inputTree();
        System.out.println(lowestCommonAncestor(head, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        TreeNode cur = root;
        while (cur.val < p.val || cur.val > q.val) {
            if (cur.val < p.val) {
                cur = cur.right;
            }
            else {
                cur = cur.left;
            }
        }
        return cur;
    }
}
