package lc.list;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @description
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * <a href=https://leetcode.com/problems/search-in-rotated-sorted-array/>refer</a>
 * <p>test cases:</p>
 * <p>[4,5,6,7,0,1,2]
 * 0
 * [4,5,6,7,0,1,2]
 * 3
 * [1]
 * 0</p>
 * @date 2021/7/4
 **/
public class L33 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the tar:");
        int tar = scanner.nextInt();

    }
    public int search(int[] nums, int target) {
        for (int i = 0;i<nums.length;i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
