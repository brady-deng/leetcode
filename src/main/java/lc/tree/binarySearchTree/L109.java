package lc.tree.binarySearchTree;

import lc.common.ob.TreeNode;
import lc.common.ob.ListNode;
import lc.tree.myTest.L109Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 * </p>
 * <a href=https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/>ref</a>
 * <p>
 *     [-10,-3,0,5,9] --> [0,-3,9,-10,null,5]
 * [] --> []
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/20
 **/
public class L109 {

    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = ListNode.deserialize(nums);
        System.out.println(head);
        TreeNode res = new L109().sortedListToBST(head);
        System.out.println(res);
        TreeNode res2 = new L109Test().sortedListToBST(head);
        System.out.println(res2);
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> res = getVals(head);
        return buildBST(res, 0, res.size()-1);

    }

    public TreeNode buildBST(List<Integer> res, int start, int end) {
        if (end < start) return null;
        else if (end == start) return new TreeNode(res.get(start));
        else  {

            int mid = (start+end)/2;
            TreeNode head = new TreeNode(res.get(mid));
            if (mid > start+2) {
                head.left = buildBST(res, start, mid-1);
            }
            else if (mid != start){
                TreeNode left = new TreeNode(res.get(start));
                TreeNode leftTmp = left;
                for (int i = start+1; i < mid; i++) {
                    leftTmp.right = new TreeNode(res.get(i));
                    leftTmp = leftTmp.right;
                }
                head.left = left;
            }
            if ((end-mid) > 2) {
                head.right = buildBST(res, mid+1, end);
            }
            else if (mid != end){
                TreeNode right = new TreeNode(res.get(mid+1));
                TreeNode rightTmp = right;
                for (int i = mid+2; i <= end; i++) {
                    rightTmp.right = new TreeNode(res.get(i));
                    rightTmp = right.right;
                }
                head.right = right;
            }
            return head;
        }
    }
    public static List<Integer> getVals(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res;
    }
}
