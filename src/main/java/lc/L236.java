package main.java.lc;

import main.java.lc.common.ob.TreeNode;

import java.util.List;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/10/9
 **/
public class L236 {
    public static void main(String[] args) {
        TreeNode head = LUtil.inputTree();
        TreeNode p = LUtil.inputTree();
        TreeNode q = LUtil.inputTree();
        System.out.println(new L236Ans().lowestCommonAncestor(head, p, q).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        List<Integer> vals = TreeNode.inorderTraversal(root);
        while (cur != null) {
            List<Integer> left = vals.subList(0, vals.indexOf(cur.val)+1);
            List<Integer> right = vals.subList(vals.indexOf(cur.val), vals.size());
            if ((left.contains(p.val) && right.contains(q.val)) || (left.contains(q.val) && right.contains(p.val))) {
                return cur;
            }
            else if (left.contains(p.val) && left.contains(q.val)) {
                vals = left;
                cur = cur.left;
            }
            else {
                vals = right;
                cur = cur.right;
            }
        }
        return cur;
    }

}
