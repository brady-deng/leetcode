package main.java.lc.list;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 * <p>Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.</p>
 *
 * <a href=https://leetcode.com/problems/first-missing-positive/></a>
 * <p>[1,2,0]
 * [3,4,-1,1]
 * [7,8,9,11,12]</p>
 **/
public class L41 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(firstMissingPositive(nums));

    }
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)    return i+1;
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
