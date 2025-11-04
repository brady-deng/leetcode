package lc.node.mytest;

import lc.common.ob.ListNode;
import lc.common.ob.TreeNode;
import lc.util.LUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/9
 **/
public class N214Test {

    public static void main(String[] args) {
        TreeNode root = LUtil.inputTree();
        System.out.println(new N214Test().solution(root));

    }

    /**
     * 8,3,10,1,6,null,14,null,null,4,7,13
     * @param root
     * @return
     */
    public List<TreeNode> solution(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        int[] val = new int[2];
        recurSolution(root, new ArrayList<>(), val, res);
        return res;
    }

    public void recurSolution(TreeNode cur, List<TreeNode> tmp, int[] val, List<TreeNode> res) {
        val[0] += cur.val;
        tmp.add(cur);
        if (cur.left == null && cur.right == null) {
            if (val[0] > val[1]) {
                val[1] = val[0];
                res.clear();
                res.addAll(tmp);
            }
        }
        if (cur.left != null) {
            recurSolution(cur.left, tmp, val, res);
        }
        if (cur.right != null) {
            recurSolution(cur.right, tmp, val, res);
        }
        tmp.remove(tmp.size()-1);
        val[0]-=cur.val;
    }
}
