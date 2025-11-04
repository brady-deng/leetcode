package lc.tree.binarySearchTree;

import lc.common.ob.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 * </p>
 * <a href = https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/>ref</a>
 * <p>
 *     [-10,-3,0,5,9] --> [0,-3,9,-10,null,5]
 * [1,3] --> [3,1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/30
 **/
public class L108 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        TreeNode head = sortedArrayToBST(nums);
        System.out.println(head);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
    public static TreeNode buildTree(int[] nums, int left, int right) {
        if (right-left > 1) {
            int mid = left+(right-left)/2;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = buildTree(nums, left, mid-1);
            head.right = buildTree(nums, mid+1, right);
            return head;
        }
        else {
            TreeNode head = new TreeNode(nums[left]);
            if (right > left) {
                head.right = new TreeNode(nums[right]);
            }
            return head;
        }
    }
}
