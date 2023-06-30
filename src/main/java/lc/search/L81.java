package main.java.lc.search;

import java.util.Arrays;
import java.util.Scanner;


/**
 * <p>
 *     There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 * </p>
 * <a href = https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/520569776/>ref</a>
 * <p>
 *     [2,5,6,0,0,1,2]
 * 0
 * true
 *
 *
 * [2,5,6,0,0,1,2]
 * 3
 * false
 * </p>
 */
public class L81 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(search(nums, target));
    }
    public static boolean search(int[] nums, int target) {
        for (int item:nums) {
            if (item == target) {
                return true;
            }
        }
        return false;
    }
}
