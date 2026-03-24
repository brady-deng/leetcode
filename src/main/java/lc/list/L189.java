package main.java.lc.list;

import main.java.lc.list.test.L189Test;
import main.java.lc.util.LUtil;

import java.util.Arrays;

/**
 * <p>
 *     Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * </p>
 * <a href=https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * </a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/3
 **/
public class L189 {


    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int k = LUtil.inputNum();
        new L189Test().rotate(nums, k);
        LUtil.printNums(nums);
    }
    public void rotate(int[] nums, int k) {
        int mod = k % nums.length;
        if (mod == 0) {
            return;
        }
        int[] last = Arrays.copyOfRange(nums, nums.length-mod, nums.length);
        int[] first = Arrays.copyOfRange(nums, 0, nums.length-mod);
        int i = 0;
        while (i < last.length) {
            nums[i] = last[i];
            i++;
        }
        while (i-mod < first.length) {
            nums[i] = first[i-mod];
            i++;
        }
    }

    public void rotateans(int[] nums, int k) {
        // Ensure k is within array bounds
        k %= nums.length;
        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int nums[], int start, int end){
        // While start index is less than end index
        while(start < end){
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Increment start index and decrement end index
            start++;
            end--;
        }
    }

}
