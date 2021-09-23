package lc;

import java.util.List;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/9/23
 **/
public class L230 {
    public static void main(String[] args) {

        TreeNode head = LUtil.inputTree();
        int k = LUtil.inputNum();
        System.out.println(kthSmallest(head, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = TreeNode.inorderTraversal(root);
        return nums.get(k-1);
    }
}
