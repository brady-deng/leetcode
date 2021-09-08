package lc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
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
