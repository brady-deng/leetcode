package lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/16
 **/
public class L99Ans {
    TreeNode prev = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        evalSwappedNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void evalSwappedNodes(TreeNode curr) {
        if (curr == null)
            return;
        evalSwappedNodes(curr.left);
        if (prev != null && prev.val > curr.val) {
            if (first == null)
                first = prev;
            second = curr;
        }
        prev = curr;
        evalSwappedNodes(curr.right);
    }
}
