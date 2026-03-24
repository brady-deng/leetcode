package main.java.lc.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * </p>
 * <a href = https://leetcode.com/problems/jump-game/>ref</a>
 * <p>
 *     [2,3,1,1,4] --> true
 * [3,2,1,0,4] --> false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/7
 **/
public class L55 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0;i<nums.length-1;i++) {
            if (max >= i) {
                max = Math.max(max, nums[i]+i);
                if (max >= nums.length-1) return true;
            }
            else return false;
        }
        return max>=nums.length-1;
    }
}
