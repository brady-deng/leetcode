package lc.tree;

import lc.common.ob.TreeNode;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230703
 **/
public class L100Ans {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) { return p == q;}

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
